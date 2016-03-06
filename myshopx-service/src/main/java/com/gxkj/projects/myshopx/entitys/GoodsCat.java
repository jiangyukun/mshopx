package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "goods_cat")
public class GoodsCat   implements Serializable {

    private static final long serialVersionUID = 3654887365292290380L;

    @Id
    private GoodsCatPK goodsCatPK;

    public GoodsCatPK getGoodsCatPK() {
        return goodsCatPK;
    }

    public void setGoodsCatPK(GoodsCatPK goodsCatPK) {
        this.goodsCatPK = goodsCatPK;
    }
}
