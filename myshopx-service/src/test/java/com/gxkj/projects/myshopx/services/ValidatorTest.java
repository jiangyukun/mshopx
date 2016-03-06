package com.gxkj.projects.myshopx.services;

import com.gxkj.projects.myshopx.entitys.Brand;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by xubaoyong on 2016/3/5.
 */
public class ValidatorTest extends BaseSpringTest  {
    Logger LOG = LoggerFactory.getLogger(ValidatorTest.class);


    @Override
    public void before() {
        super.before();
    }

    @Autowired
    private Validator validator = null;

    @Test
    public void validUserTest(){
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();

        Brand brand = new Brand();

        Set<ConstraintViolation<Brand>> constraintViolations = validator.validate(brand);

        for (ConstraintViolation<Brand> constraintViolation : constraintViolations) {
            System.out.println("对象属性:"+constraintViolation.getPropertyPath());
            System.out.println("国际化key:"+constraintViolation.getMessageTemplate());
            System.out.println("错误信息:"+constraintViolation.getMessage());
        }



//        MapBindingResult errors = new MapBindingResult(new HashMap(), "");
//        validator.validate(brand, errors );
//        LOG.info("errors="+ JSON.toJSONString(errors));
    }
}
