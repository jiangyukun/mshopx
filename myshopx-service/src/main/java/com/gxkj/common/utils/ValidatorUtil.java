package com.gxkj.common.utils;


import com.gxkj.common.dto.ValidateDescDto;
import com.gxkj.common.exceptions.ValidateException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xubaoyong on 2016/3/6.
 */
public class ValidatorUtil {

    private  Validator validator;

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * 进行验证策略
     * @param entity    被检测的错误
     * @param singleCheck  true:有一个错误立即返回，这样不用继续循环了;否则继续遍历直到所有的错误遍历完
     * @param <T>
     * @throws ValidateException
     */
    public <T> void validate(T entity ,Boolean singleCheck) throws ValidateException {

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);

        List<ValidateDescDto> dtos = new ArrayList<ValidateDescDto>();

        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            ValidateDescDto dto = new ValidateDescDto();
            dto.setField(constraintViolation.getPropertyPath().toString());
            dto.setErrorKey(constraintViolation.getMessageTemplate());
            dto.setErrorMsg(constraintViolation.getMessage());
                if(singleCheck){
                    throw  new ValidateException(dto);
                }else {
                    dtos.add(dto);
                }
//            System.out.println("对象属性:"+constraintViolation.getPropertyPath());
//            System.out.println("国际化key:"+constraintViolation.getMessageTemplate());
//            System.out.println("错误信息:"+constraintViolation.getMessage());
        }

        if(!dtos.isEmpty()){
            throw  new ValidateException(dtos);
        }

    }
}
