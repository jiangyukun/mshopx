package com.gxkj.projects.myshopx.entitys;

import com.gxkj.projects.myshopx.enums.CategoryState;

import javax.persistence.*;

/**
 * 商品分类
 */
@Entity
@Table(name = "category")
public class Category extends BaseModel{

    private static final long serialVersionUID = -1679437707365467621L;

    @Column(name="cat_name",nullable = false)
    private String catName;//分类名称

    @Column(name="keywords",nullable = false)
    private String keywords;//关键字

    @Column(name="cat_desc",nullable = false)
    private String catDesc;//分类描述

    @Column(name="parent_id",nullable = false)
    private String parentId;//上级分类

    @Column(name="sort_order",nullable = false)
    private int sortOrder;//排序

    @Column(name="template_file",nullable = false)
    private String templateFile;

    @Column(name="measure_unit",nullable = false)
    private String measureUnit;//数量单位

    @Column(name="show_in_nav",nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean showInNav;//导航栏

    @Column(name="style" ,nullable = false)
    private String style;

    @Column(name="is_show" ,nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private boolean show;//是否显示

    @Column(name="grade" ,nullable = false)
    private int grade;//价格分级


    @Column(name="filter_attr",nullable = false)
    private String filterAttr;//筛选属性

    @Enumerated(EnumType.STRING)
    @Column(name="states",nullable = false)//状态
    private CategoryState states;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }



    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFilterAttr() {
        return filterAttr;
    }

    public void setFilterAttr(String filterAttr) {
        this.filterAttr = filterAttr;
    }

    public CategoryState getStates() {
        return states;
    }

    public void setStates(CategoryState states) {
        this.states = states;
    }


    public boolean isShowInNav() {
        return showInNav;
    }

    public void setShowInNav(boolean showInNav) {
        this.showInNav = showInNav;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
