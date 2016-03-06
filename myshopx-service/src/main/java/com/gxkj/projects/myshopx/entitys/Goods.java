package com.gxkj.projects.myshopx.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by dell on 2016/3/5.
 */
@Entity
@Table(name = "goods")
public class Goods extends BaseModel{

    private static final long serialVersionUID = -7741065959215491504L;
    @Column(name="cat_id",nullable = false)
    private  String catId;//

    @Column(name="goods_sn",nullable = false,length = 600)
    private  String goodsSn;//

    @Column(name="goods_name",nullable = false,length = 120)
    private  String goodsName;//

    @Column(name="goods_name_style",nullable = false,length = 60)
    private  String goodsNameStyle;//

    @Column(name="click_count",nullable = false,length = 10)
    private  int  clickCount;//

    @Column(name="brand_id",nullable = false,length = 64)
    private  String  brandId;//

    @Column(name="provider_name",nullable = false,length = 100)
    private  String  providerName;//

    @Column(name="goods_number",nullable = false,length = 5)
    private  int  goodsNumber;//

    @Column(name="goods_weight",nullable = false )
    private BigDecimal goodsWeight;//

    @Column(name="market_price",nullable = false )
    private BigDecimal marketPrice;//

    @Column(name="shop_price",nullable = false )
    private BigDecimal shopPrice;//

    @Column(name="promote_price",nullable = false )
    private BigDecimal promotePrice;//

    @Column(name="promote_start_date",nullable = false )
    private int promoteStartDate;

    @Column(name="promote_end_date",nullable = false )
    private int promoteEndDate;

    @Column(name="warn_number",nullable = false )
    private int warnNumber;


    @Column(name="keywords",nullable = false ,length = 256)
    private String keywords;

    @Column(name="goods_brief",nullable = false ,length = 256)
    private String goodsBrief;

    @Column(name="goods_desc",nullable = false)
    private String goodsDesc;

    @Column(name="goods_thumb",nullable = false)
    private String goodsThumb;

    @Column(name="goods_img",nullable = false)
    private String goodsImg;

    @Column(name="original_img",nullable = false)
    private String originalImg;

    @Column(name="is_real",nullable = false)
    private int isReal;

    @Column(name="extension_code",nullable = false ,length = 30)
    private String extensionCode;

    @Column(name="is_on_sale",nullable = false  )
    private int isOnSale;

    @Column(name="is_alone_sale",nullable = false  )
    private int isAloneSale;

    @Column(name="is_shipping",nullable = false  )
    private int isShipping;

    @Column(name="integral",nullable = false  )
    private int integral;

    @Column(name="add_time",nullable = false  )
    private int add_time;

    @Column(name="sort_order",nullable = false  )
    private int sortOrder;

    @Column(name="is_delete",nullable = false  )
    private int isDelete;

    @Column(name="is_best",nullable = false  )
    private int isDest;

    @Column(name="is_new",nullable = false  )
    private int isNew;

    @Column(name="is_hot",nullable = false  )
    private int isHot;

    @Column(name="is_promote",nullable = false  )
    private int isPromote;

    @Column(name="bonus_type_id",nullable = false  )
    private int bonusTypeId;

    @Column(name="goods_type",nullable = false  )
    private int goodsType;

    @Column(name="seller_note",nullable = false ,length = 30)
    private String sellerNote;

    @Column(name="give_integral",nullable = false  )
    private int giveIntegral;

    @Column(name="rank_integral",nullable = false  )
    private int rankIntegral;

    @Column(name="suppliers_id",nullable = false ,length = 64)
    private String suppliersId;

    @Column(name="is_check",nullable = false  )
    private int isCheck;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNameStyle() {
        return goodsNameStyle;
    }

    public void setGoodsNameStyle(String goodsNameStyle) {
        this.goodsNameStyle = goodsNameStyle;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public int getPromoteStartDate() {
        return promoteStartDate;
    }

    public void setPromoteStartDate(int promoteStartDate) {
        this.promoteStartDate = promoteStartDate;
    }

    public int getPromoteEndDate() {
        return promoteEndDate;
    }

    public void setPromoteEndDate(int promoteEndDate) {
        this.promoteEndDate = promoteEndDate;
    }

    public int getWarnNumber() {
        return warnNumber;
    }

    public void setWarnNumber(int warnNumber) {
        this.warnNumber = warnNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsThumb() {
        return goodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getOriginalImg() {
        return originalImg;
    }

    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg;
    }

    public int getIsReal() {
        return isReal;
    }

    public void setIsReal(int isReal) {
        this.isReal = isReal;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public int getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(int isOnSale) {
        this.isOnSale = isOnSale;
    }

    public int getIsAloneSale() {
        return isAloneSale;
    }

    public void setIsAloneSale(int isAloneSale) {
        this.isAloneSale = isAloneSale;
    }

    public int getIsShipping() {
        return isShipping;
    }

    public void setIsShipping(int isShipping) {
        this.isShipping = isShipping;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getIsDest() {
        return isDest;
    }

    public void setIsDest(int isDest) {
        this.isDest = isDest;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsPromote() {
        return isPromote;
    }

    public void setIsPromote(int isPromote) {
        this.isPromote = isPromote;
    }

    public int getBonusTypeId() {
        return bonusTypeId;
    }

    public void setBonusTypeId(int bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
    }

    public int getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(int giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    public int getRankIntegral() {
        return rankIntegral;
    }

    public void setRankIntegral(int rankIntegral) {
        this.rankIntegral = rankIntegral;
    }

    public String getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(String suppliersId) {
        this.suppliersId = suppliersId;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }
}
