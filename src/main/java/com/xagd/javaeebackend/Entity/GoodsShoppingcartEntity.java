package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "goods_shoppingcart", schema = "db", catalog = "")
@IdClass(GoodsShoppingcartEntityPK.class)
public class GoodsShoppingcartEntity {
    private short goodsId;
    private short userId;
    private byte goodsCategory;
    private String goodsName;
    private BigDecimal goodsPrice;
    private Timestamp goodsDate;
    private short sellNum;
    private byte sellStatus;
    private String goodsIntroduction;
    private short goodsFavorite;
    private String goodsUnit;
    private short shoppingCartId;
    private short count;

    @Basic
    @Id
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "goods_category")
    public byte getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(byte goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_price")
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "goods_date")
    public Timestamp getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Timestamp goodsDate) {
        this.goodsDate = goodsDate;
    }

    @Basic
    @Column(name = "sell_num")
    public short getSellNum() {
        return sellNum;
    }

    public void setSellNum(short sellNum) {
        this.sellNum = sellNum;
    }

    @Basic
    @Column(name = "sell_status")
    public byte getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(byte sellStatus) {
        this.sellStatus = sellStatus;
    }

    @Basic
    @Column(name = "goods_introduction")
    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    @Basic
    @Column(name = "goods_favorite")
    public short getGoodsFavorite() {
        return goodsFavorite;
    }

    public void setGoodsFavorite(short goodsFavorite) {
        this.goodsFavorite = goodsFavorite;
    }

    @Basic
    @Column(name = "goods_unit")
    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    @Basic
    @Id
    @Column(name = "shopping_cart_id")
    public short getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(short shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Basic
    @Column(name = "count")
    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsShoppingcartEntity that = (GoodsShoppingcartEntity) o;

        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;
        if (goodsCategory != that.goodsCategory) return false;
        if (sellNum != that.sellNum) return false;
        if (sellStatus != that.sellStatus) return false;
        if (goodsFavorite != that.goodsFavorite) return false;
        if (shoppingCartId != that.shoppingCartId) return false;
        if (count != that.count) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(that.goodsPrice) : that.goodsPrice != null) return false;
        if (goodsDate != null ? !goodsDate.equals(that.goodsDate) : that.goodsDate != null) return false;
        if (goodsIntroduction != null ? !goodsIntroduction.equals(that.goodsIntroduction) : that.goodsIntroduction != null)
            return false;
        if (goodsUnit != null ? !goodsUnit.equals(that.goodsUnit) : that.goodsUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) goodsId;
        result = 31 * result + (int) userId;
        result = 31 * result + (int) goodsCategory;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (goodsDate != null ? goodsDate.hashCode() : 0);
        result = 31 * result + (int) sellNum;
        result = 31 * result + (int) sellStatus;
        result = 31 * result + (goodsIntroduction != null ? goodsIntroduction.hashCode() : 0);
        result = 31 * result + (int) goodsFavorite;
        result = 31 * result + (goodsUnit != null ? goodsUnit.hashCode() : 0);
        result = 31 * result + (int) shoppingCartId;
        result = 31 * result + (int) count;
        return result;
    }
}
