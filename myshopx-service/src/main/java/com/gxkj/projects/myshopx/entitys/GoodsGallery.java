package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "goods_gallery")
public class GoodsGallery extends BaseModel{

    private static final long serialVersionUID = 6168711086696503405L;

    @Column(name="goods_id",nullable = false)
    private  String goodsId;//

    @Column(name="img_url",nullable = false)
    private  String imgUrl;//

    @Column(name="img_desc",nullable = false)
    private  String imgDesc;//


    @Column(name="thumb_url",nullable = false)
    private  String thumbUrl;//

    @Column(name="img_original",nullable = false)
    private  String imgOriginal;//

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getImgOriginal() {
        return imgOriginal;
    }

    public void setImgOriginal(String imgOriginal) {
        this.imgOriginal = imgOriginal;
    }
}
