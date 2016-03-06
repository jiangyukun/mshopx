package com.gxkj.common.dto;

import java.io.Serializable;

/**
 * 验证错误描述
 *
 */
public class ValidateDescDto  implements Serializable {
    private static final long serialVersionUID = -8789379725816100121L;

    private String field; //异常字段

    private String errorKey;//错误字段上面的验证标识

    private String errorMsg;//i18 里的错误提示

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
