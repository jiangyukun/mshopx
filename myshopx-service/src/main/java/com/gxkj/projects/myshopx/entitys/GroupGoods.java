package com.gxkj.projects.myshopx.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods_type")
public class GroupGoods implements Serializable {

    private static final long serialVersionUID = 6159085680461754039L;

    @Embedded
    @Id
    private  GroupGoodsPK groupGoodsPK;//


    @Column(name="goods_price",nullable = false)
    private BigDecimal goodsPrice;//


    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public GroupGoodsPK getGroupGoodsPK() {
        return groupGoodsPK;
    }

    public void setGroupGoodsPK(GroupGoodsPK groupGoodsPK) {
        this.groupGoodsPK = groupGoodsPK;
    }
}
