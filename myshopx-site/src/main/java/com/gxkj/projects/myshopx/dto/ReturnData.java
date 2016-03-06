package com.gxkj.projects.myshopx.dto;

import java.io.Serializable;

/**
 * Created by xubaoyong on 2016/3/6.
 */
public class ReturnData<T> implements Serializable {
    private static final long serialVersionUID = 4469678268979716173L;

    private String statusCode;

    private T entity;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
