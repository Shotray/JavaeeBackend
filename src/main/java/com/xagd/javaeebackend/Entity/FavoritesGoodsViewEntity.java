package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TODO:此处写FavoritesGoodsViewEntity类的描述
 *
 * @author shotray
 * @since 2021/12/12 21:17
 */

@Entity
@Table(name = "favorites_goods_view", schema = "db", catalog = "")
@IdClass(FavoritesGoodsViewEntityPK.class)
public class FavoritesGoodsViewEntity {
    private short favoritesId;
    private short goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private short sellNum;

    @Id
    @Basic
    @Column(name = "favorites_id")
    public short getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Id
    @Basic
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
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
    @Column(name = "sell_num")
    public short getSellNum() {
        return sellNum;
    }

    public void setSellNum(short sellNum) {
        this.sellNum = sellNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritesGoodsViewEntity that = (FavoritesGoodsViewEntity) o;

        if (favoritesId != that.favoritesId) return false;
        if (goodsId != that.goodsId) return false;
        if (sellNum != that.sellNum) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(that.goodsPrice) : that.goodsPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) favoritesId;
        result = 31 * result + (int) goodsId;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (int) sellNum;
        return result;
    }
}

