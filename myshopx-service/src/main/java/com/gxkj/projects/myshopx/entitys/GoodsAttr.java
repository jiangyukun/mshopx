package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods_attr")
public class GoodsAttr  extends BaseModel{
    private static final long serialVersionUID = 3781228332111849928L;

    @Column(name="goods_id",nullable = false)
    private  String goodsId;//

    @Column(name="attr_id",nullable = false)
    private  String attrId;//

    @Column(name="attr_value",nullable = false)
    private  String attrValue;//

    @Column(name="attr_price",nullable = false)
    private  String attrPrice;//
}
