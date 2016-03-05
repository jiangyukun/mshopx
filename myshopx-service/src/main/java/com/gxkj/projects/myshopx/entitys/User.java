package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.GenderEnums;

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

    @Column(name="staus",length=32)
    private String staus;

    @Column(name="is_admin",length=1)
    private int  isAdmin = 0;

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

    public String getStaus() {
        return staus;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
