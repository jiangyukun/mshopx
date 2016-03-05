package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods_activity")
public class GoodsActivity  extends BaseModel{
    private static final long serialVersionUID = 7849779519473576891L;

    @Column(name="act_name",nullable = false)
    private String actName;

    @Column(name="act_desc",nullable = false)
    private String actDesc;

    @Column(name="act_type",nullable = false)
    private int actType;

    @Column(name="goods_id",nullable = false)
    private String goodsId;

    @Column(name="product_id",nullable = false)
    private String productId;

    @Column(name="goods_name",nullable = false)
    private String goodsName;

    @Column(name="start_time",nullable = false)
    private int  startTime;

    @Column(name="end_time",nullable = false)
    private int  endTime;

    @Column(name="is_finished",nullable = false)
    private int  isFinished;

    @Column(name="ext_info",nullable = false)
    private String extInfo;


    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActDesc() {
        return actDesc;
    }

    public void setActDesc(String actDesc) {
        this.actDesc = actDesc;
    }

    public int getActType() {
        return actType;
    }

    public void setActType(int actType) {
        this.actType = actType;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}
