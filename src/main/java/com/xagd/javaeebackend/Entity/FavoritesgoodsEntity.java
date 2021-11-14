package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "favoritesgoods", schema = "db", catalog = "")
@IdClass(FavoritesgoodsEntityPK.class)
public class FavoritesgoodsEntity {
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

        FavoritesgoodsEntity that = (FavoritesgoodsEntity) o;

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
