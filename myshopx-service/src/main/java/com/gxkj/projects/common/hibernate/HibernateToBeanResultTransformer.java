package com.gxkj.projects.common.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 *
 */
public class HibernateToBeanResultTransformer  extends AliasedTupleSubsetResultTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(HibernateToBeanResultTransformer.class);
    private final Class resultClass;
    private boolean isInitialized;
    private String[] aliases;
    private Method[] setters;

    private Map<String,PropertyBean> propertyBeanMap = null;

    public HibernateToBeanResultTransformer(Class resultClass) {
        if(resultClass == null) {
            throw new IllegalArgumentException("resultClass cannot be null");
        } else {
            this.isInitialized = false;
            this.resultClass = resultClass;
        }
    }

    public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
        return false;
    }

    /**
     *
     * @param tuple  值数组
     * @param aliases   字段数组
     * @return
     */
    public Object transformTuple(Object[] tuple, String[] aliases) {
        try {
            /**
             * 1:确保查到的结果为非空
             * 2：遍历类里所有的属性
             */
            if(tuple == null || tuple.length == 0){
                return null;
            }
            if(!this.isInitialized) {
                this.initialize(aliases);
            }
            Object result = this.resultClass.newInstance();
            PropertyBean tempPropertyBean = null;
            Method tempMethod = null;
            for(int e = 0; e < aliases.length; ++e) {
                tempPropertyBean = propertyBeanMap.get(aliases[e].toUpperCase());
                if(tempPropertyBean!=null){
                    tempMethod = tempPropertyBean.getPropertyWriteMethod();
                    try {

                        if(HibernateResultTransformerUtil.isBaseType(tempPropertyBean.getPropertyClass())){

                            try{
                                tempMethod.invoke(result,tuple[e]);
                            }catch (IllegalArgumentException ex){
                                LOG.info("类型不匹配,属性{}的类型为{},数据库查出值的类型为"+tuple[e].getClass().getName(),aliases[e],tempPropertyBean.getPropertyClass().getName());
                            }
                        }else if(tempPropertyBean.getPropertyClass().isEnum()  && tuple[e] != null){
                            //对枚举类进行特别处理
                            Object[] ts = tempPropertyBean.getPropertyClass().getEnumConstants();
                            boolean find = false;
                            for (Object t : ts) {
                                Enum<?> e1 = (Enum<?>) t;
                                if(e1.name().equals(tuple[e].toString())){
                                    tuple[e] = e1;
                                    find = true;
                                    break;
                                }
                            }
                            if(!find){
                                throw new HibernateException(String.format("类：%s的属性%s的数据库类型在枚举类%s里没有找到配配的类型,数据库值：%s",
                                        this.resultClass.getName(),
                                        aliases[e],
                                        tempPropertyBean.getPropertyClass().getName(),
                                        tuple[e].toString()));
                            }else {
                                try{
                                    tempMethod.invoke(result,tuple[e]);
                                }catch (IllegalArgumentException ex){
                                    LOG.info("类型不匹配,属性{}的类型为{},数据库查出值的类型为"+tuple[e].getClass().getName(),aliases[e],tempPropertyBean.getPropertyClass().getName());
                                }
                            }
                        }

                    } catch (InvocationTargetException e1) {
                        LOG.info("{}类对象调用{}方法失败：",this.resultClass.getName(),tempMethod.getName());
                        e1.printStackTrace();
                    }
                }else{
                    LOG.info("类{}没有属性：{}",this.resultClass.getName(),aliases[e]);
                }

            }

            return result;
        } catch (InstantiationException var5) {
            throw new HibernateException("Could not instantiate resultclass: " + this.resultClass.getName());
        } catch (IllegalAccessException var6) {
            throw new HibernateException("Could not instantiate resultclass: " + this.resultClass.getName());
        }
    }

    private void initialize(String[] aliases) {

        propertyBeanMap = HibernateResultTransformerUtil.getColumn2PropertyMap(this.resultClass);
        this.isInitialized = true;
    }
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o != null && this.getClass() == o.getClass()) {
            HibernateToBeanResultTransformer that = (HibernateToBeanResultTransformer)o;
            return !this.resultClass.equals(that.resultClass)?false:Arrays.equals(this.aliases, that.aliases);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.resultClass.hashCode();
        result = 31 * result + (this.aliases != null?Arrays.hashCode(this.aliases):0);
        return result;
    }
}
