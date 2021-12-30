package com.xagd.javaeebackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写FavoritesGoodsEntityPK类的描述
 *
 * @author shotray
 * @since 2021/12/30 15:24
 */

public class FavoritesGoodsEntityPK implements Serializable {
    private short favoritesId;
    private short goodsId;

    @Column(name = "favorites_id")
    @Id
    public short getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritesGoodsEntityPK that = (FavoritesGoodsEntityPK) o;

        if (favoritesId != that.favoritesId) return false;
        if (goodsId != that.goodsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) favoritesId;
        result = 31 * result + (int) goodsId;
        return result;
    }
}

