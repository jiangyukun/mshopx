package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods_type")
public class GoodType extends BaseModel{
    private static final long serialVersionUID = 4023343985425154335L;

    @Column(name="cat_name",nullable = false)
    private  String catName;//

    @Column(name="enabled",nullable = false)
    private  int  enabled;//

    @Column(name="attr_group",nullable = false)
    private  String attrGroup;//

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getAttrGroup() {
        return attrGroup;
    }

    public void setAttrGroup(String attrGroup) {
        this.attrGroup = attrGroup;
    }
}
