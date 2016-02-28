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

    @Column(name="user_name",length=40)
    private String userName;

    @Column(name="gender",length=40)
    @Enumerated(EnumType.STRING)
    private GenderEnums gender;

    @Column(name="age")
    private int age;

    @Column(name="birthday",nullable = false)
    @Temporal(TemporalType.TIMESTAMP )
    private Date birthday;

    @Column(name="admin")
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean admin;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public GenderEnums getGender() {
        return gender;
    }

    public void setGender(GenderEnums gender) {
        this.gender = gender;
    }


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
