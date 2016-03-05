package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel{

    private static final long serialVersionUID = 6872005489260489391L;

    @Column(name="comment_type",nullable = false)
    private int comment_type;

    @Column(name="id_value",nullable = false)
    private String idValue;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name="user_name",nullable = false)
    private String userName;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="comment_rank",nullable = false)
    private int commentRank;

    @Column(name="add_time",nullable = false)
    private int add_time;

    @Column(name="ip_address",nullable = false)
    private String ipAddress;

    @Column(name="status",nullable = false)
    private int status;

    @Column(name="parent_id",nullable = false)
    private String parentId;

    @Column(name="user_id",nullable = false)
    private String userId;
}
