package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods_type")
public class GroupGoods implements Serializable {

    private static final long serialVersionUID = 6159085680461754039L;
    @Column(name="parent_id",nullable = false)
    private  String parentId;//

    @Column(name="goods_id",nullable = false)
    private  String  goodsId;//

    @Column(name="goods_price",nullable = false)
    private BigDecimal goodsPrice;//

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

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
