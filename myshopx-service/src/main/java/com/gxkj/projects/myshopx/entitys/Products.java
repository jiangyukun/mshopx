package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products extends BaseModel{

    private static final long serialVersionUID = -3771245536798398325L;
    @Column(name="goods_id",nullable = false)
    private  String  goodsId;//

    @Column(name="goods_attr",nullable = false)
    private  String  goodsAttr;//

    @Column(name="product_sn",nullable = false)
    private  String  productSn;//

    @Column(name="product_number",nullable = false)
    private  int  productNumber;//

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(String goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
}
