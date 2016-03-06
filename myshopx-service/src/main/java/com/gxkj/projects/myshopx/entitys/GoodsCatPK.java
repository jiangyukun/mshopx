package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GoodsCatPK  implements Serializable {

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
