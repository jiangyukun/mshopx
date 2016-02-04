package utils.beanutil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gxkj.projects.common.hibernate.HibernateResultTransformerUtil;
import com.gxkj.projects.myshopx.entitys.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.Map;

/**
 * Created by dell on 2016/2/1.
 */
public class BeanUtilTest {
    private static final Logger LOG = LoggerFactory.getLogger(BeanUtilTest.class);

    public <T> void test(Class<T> clazz ){
        Field[] dFields =  clazz.getDeclaredFields();
        Field[] cFields =clazz.getFields();

        ProtectionDomain protectionDomain = clazz.getProtectionDomain();

        LOG.info( JSONObject.toJSONString(dFields));
        LOG.info( JSONObject.toJSONString(cFields));
        LOG.info( "protectionDomain={}",JSONObject.toJSONString(protectionDomain));

        String fName = null;
        //父类
        for(Class supperClass = clazz.getSuperclass() ;supperClass.getName() != Object.class.getName(); ){
            Field[] superClassFields =  supperClass.getDeclaredFields();
            for(Field filed: superClassFields){
                fName = filed.getName();
                int modifiter = filed.getModifiers();
                //supperClass.getDeclaredMethod()
                System.out.println("fName="+fName +" modifiter="+ Modifier.toString(modifiter));
            }
            supperClass = supperClass.getSuperclass();
        }
    }
    public static void main(String[] args){
//        LOG.info(Object.class.getName());
//        Map map = HibernateResultTransformerUtil.init(User.class);
//        LOG.info(JSON.toJSONString(map));
        new BeanUtilTest().propertyUtil();
    }

    public void propertyUtil(){
        Class clazz = User.class;
        PropertyDescriptor[] propertyDescriptors =  PropertyUtils.getPropertyDescriptors(clazz);
        String pName = null;
        Field field = null;
        for(int i=0;i<propertyDescriptors.length;i++){
            pName = propertyDescriptors[i].getName();
            if("class".equals(pName)){
                continue;
            }
            LOG.info(JSON.toJSONString(propertyDescriptors[i].getName()));
        }
    }
}
