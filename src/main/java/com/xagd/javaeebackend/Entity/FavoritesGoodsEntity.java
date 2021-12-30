package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

/**
 * TODO:此处写FavoritesGoodsEntity类的描述
 *
 * @author shotray
 * @since 2021/12/30 15:24
 */

@Entity
@Table(name = "favorites_goods", schema = "db", catalog = "")
@IdClass(FavoritesGoodsEntityPK.class)
public class FavoritesGoodsEntity {
    private short favoritesId;
    private short goodsId;

    @Id
    @Column(name = "favorites_id")
    public short getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Id
    @Column(name = "goods_id")
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

        FavoritesGoodsEntity that = (FavoritesGoodsEntity) o;

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

