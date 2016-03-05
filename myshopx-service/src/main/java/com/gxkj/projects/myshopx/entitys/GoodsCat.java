package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "goods_cat")
public class GoodsCat   implements Serializable {
    private static final long serialVersionUID = 3654887365292290380L;

    @Column(name="goods_id",nullable = false)
    private String goodsId;

    @Column(name="cat_id",nullable = false)
    private String catId;


    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }
}
