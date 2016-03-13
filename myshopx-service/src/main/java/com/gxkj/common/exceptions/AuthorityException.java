package com.gxkj.common.exceptions;

/**
 * Created by xubaoyong on 2016/3/13.
 */
public class AuthorityException extends Exception {
    private static final long serialVersionUID = -6006270957267433270L;

    private String url;

    public AuthorityException(String url){
        super();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
