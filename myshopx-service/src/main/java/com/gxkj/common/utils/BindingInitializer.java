package com.gxkj.common.utils;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by xubaoyong on 2016/3/7.
 */
public class BindingInitializer implements WebBindingInitializer {

    public void initBinder(WebDataBinder binder, WebRequest request) {
        //binder.registerCustomEditor(SomeDataType.class, somePropertyEditor);
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(false));
    }

}