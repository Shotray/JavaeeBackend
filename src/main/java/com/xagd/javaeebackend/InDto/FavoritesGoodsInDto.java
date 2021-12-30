package com.xagd.javaeebackend.InDto;

/**
 * TODO:此处写FavoritesGoodsInDto类的描述
 *
 * @author shotray
 * @since 2021/12/30 3:53
 */

public class FavoritesGoodsInDto {
    short favoriteId;

    short goodsId;

    public short getGoodsId() {
        return this.goodsId;
    }

    public short getFavoriteId() {
        return this.favoriteId;
    }

    public void setFavoriteId(short favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }


}

