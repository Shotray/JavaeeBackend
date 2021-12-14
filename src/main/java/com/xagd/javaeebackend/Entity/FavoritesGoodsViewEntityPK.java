package com.xagd.javaeebackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FavoritesGoodsViewEntityPK implements Serializable {
    private short favoritesId;
    private short goodsId;

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "favoritesId")
    @Id
    public short getFavoritesId() {
        return this.favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritesGoodsViewEntityPK that = (FavoritesGoodsViewEntityPK) o;

        if (goodsId != that.goodsId) return false;
        if (favoritesId != that.favoritesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) favoritesId;
        result = 31 * result + (int) goodsId;
        return result;
    }
}
