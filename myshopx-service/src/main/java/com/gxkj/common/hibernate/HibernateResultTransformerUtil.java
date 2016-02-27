package com.gxkj.common.hibernate;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/2/3.
 */
public class HibernateResultTransformerUtil {
    private static final Logger LOG = LoggerFactory.getLogger(HibernateResultTransformerUtil.class);

    private static final String[] baseClassNames = new String[] {
            "java.lang.String", "int", "java.lang.Integer", "float",
            "java.lang.Float", "double", "java.lang.Double", "long",
            "java.lang.Long", "short", "java.lang.Short", "byte",
            "java.lang.Byte", "boolean", "java.lang.Boolean", "java.util.Date",
            "java.util.Timestamp", "java.sql.Timestamp", "java.sql.Date",
            "java.lang.BigDecimal","java.math.BigInteger","java.math.BigDecimal", "[B" // byte[]
    };
    public static <T> boolean isBaseType(Class<T> clazz) {
        String className = clazz.getName();
        return ArrayUtils.contains(baseClassNames, className);
    }

    public static Map<String,PropertyBean> getColumn2PropertyMap(Class<?> clazz) {

        List<Class> classList = new ArrayList<Class>();
        classList.add(clazz);
        Class superClass = clazz.getSuperclass();
        while(!(superClass.getName().equals(Object.class.getName()))){
            classList.add(superClass);
            superClass = superClass.getSuperclass();
        }
        Field field = null;
        String propertyName = null;
        String columnName = null;
        Annotation annotation = null;
        Class tempClass = null;
        Map<String,PropertyBean> column2Property = new HashMap<String,PropertyBean>();
        PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(clazz);

        PropertyDescriptor tempPropertyDescriptor = null;
        for(int i=0 ;i<properties.length;i++){

            tempPropertyDescriptor = properties[i];
            propertyName = tempPropertyDescriptor.getName();
            if("class".equals(propertyName)){
                continue;
            }
            field = null;
            //遍历当前类及其所有父类，找对对应的Field
            for(int iIndex = 0;iIndex<classList.size();iIndex++){
                tempClass = classList.get(iIndex);
                try {
                    if("class".equals(propertyName))continue;
                    field = tempClass.getDeclaredField(propertyName);
                } catch ( SecurityException e) {
                  //  e.printStackTrace();
                    field = null;
                }catch (NoSuchFieldException   e) {
                  //  e.printStackTrace();
                    field = null;
                }
                if(field != null){
                    //找到对应的Field,跳出类循环
                    break;
                }
            }
            if(field != null){
                if(field.isAnnotationPresent(Column.class )){
                    annotation = field.getAnnotation(Column.class);
                    columnName = ((Column) annotation).name();
                    if (columnName == null || columnName.length() == 0) {
                        columnName = field.getName();
                    }
                }else{
                    columnName = field.getName();
                }

                if(propertyName.equalsIgnoreCase(columnName)){
                    if (!column2Property.containsKey(columnName.toUpperCase())) {
                        PropertyBean propertyBean =  new  PropertyBean();
                        propertyBean.setField(field);
                        propertyBean.setPropertyWriteMethod( tempPropertyDescriptor.getWriteMethod());
                        propertyBean.setPropertyReadMethod(tempPropertyDescriptor.getReadMethod());
                        propertyBean.setPropertyClass(field.getType());
                        propertyBean.setPropertyName(propertyName);

                        column2Property.put(columnName.toUpperCase(), propertyBean);
                    }
                }else {
                    PropertyBean propertyBean =  new  PropertyBean();
                    propertyBean.setField(field);
                    propertyBean.setPropertyWriteMethod( tempPropertyDescriptor.getWriteMethod());
                    propertyBean.setPropertyReadMethod(tempPropertyDescriptor.getReadMethod());
                    propertyBean.setPropertyClass(field.getType());
                    propertyBean.setPropertyName(propertyName);

                    if (!column2Property.containsKey(columnName.toUpperCase())) {
                        column2Property.put(columnName.toUpperCase(), propertyBean);
                    }
                    if (!column2Property.containsKey(propertyName.toUpperCase())) {
                        column2Property.put(propertyName.toUpperCase(), propertyBean);
                    }
                }

            }
        }
        return column2Property;
    }
}
