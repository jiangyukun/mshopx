package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.BrandStates;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * 商品品牌
 */
@Entity
@Table(name = "brand")
public class Brand extends BaseModel{
    private static final long serialVersionUID = 8156338941188501418L;

    @NotBlank(message="{brand_name.null}")
    @Column(name="brand_name",nullable = false)
    private  String brandName;//品牌名称

    @Column(name="brand_logo",nullable = false)
    private String brandLogo;//品牌logo

    @Column(name="brand_desc",nullable = false)
    private String brandDesc;//品牌描述

    @Column(name="site_url",nullable = false)
    private String  siteUrl;//品牌网址

    @Column(name="sort_order",nullable = false)
    private int sortOrder;//排序

    @Column(name="is_show",nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean show;//是否显示


    @Enumerated(EnumType.STRING)
    @Column(name="states",nullable = false)//状态
    private BrandStates states;


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public BrandStates getStates() {
        return states;
    }

    public void setStates(BrandStates states) {
        this.states = states;
    }
}
