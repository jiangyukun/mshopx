package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by xubaoyong on 2016/3/5.
 */
public class GroupGoodsPK  implements Serializable {

    private static final long serialVersionUID = 5617819880866631957L;

    @Column(name="parent_id",nullable = false)
    private  String parentId;//

    @Column(name="goods_id",nullable = false)
    private  String  goodsId;//

    @Column(name="admin_id",nullable = false)
    private  String  adminId;//

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
