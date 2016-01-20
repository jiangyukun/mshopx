package com.gxkj.projects.myshopx.entitys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dell on 2016/1/14.
 */
@Entity
@Table(name = "user_t")
public class User extends BaseModel{

    @Column(name="user_name",length=40)
    private String userName;

    @Column(name="password",length=40)
    private String password;

    @Column(name="age")
    private int age;

    @Column(name="headUrl",length=40)
    private String headUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
