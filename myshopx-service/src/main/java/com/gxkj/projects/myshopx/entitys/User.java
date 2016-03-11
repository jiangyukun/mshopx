package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.GenderEnums;
import com.gxkj.projects.myshopx.enums.UserStatusEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dell on 2016/1/14.
 */
@Entity
@Table(name = "user")
public class User extends BaseModel{

    private static final long serialVersionUID = -3216639312710758696l;

    @Column(name="qq")
    private String qq;

    @Column(name="password",length=64)
    private String password;

    @Column(name="gender",length=40)
    @Enumerated(EnumType.STRING)
    private GenderEnums gender;

    @Column(name="state",length=32)
    @Enumerated(EnumType.STRING)
    private UserStatusEnum state;

    @Column(name="is_admin",nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean  admin = false;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderEnums getGender() {
        return gender;
    }

    public void setGender(GenderEnums gender) {
        this.gender = gender;
    }
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public UserStatusEnum getState() {
        return state;
    }

    public void setState(UserStatusEnum state) {
        this.state = state;
    }
}
