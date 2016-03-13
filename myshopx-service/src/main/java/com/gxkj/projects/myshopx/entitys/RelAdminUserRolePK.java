package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by xubaoyong on 2016/3/13.
 */
public class RelAdminUserRolePK implements Serializable {

    private static final long serialVersionUID = 5106022599437514385L;

    @Column(name="user_id" )
    private String userId;

    @Column(name="admin_role_id" )
    private String adminRoleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId;
    }
}
