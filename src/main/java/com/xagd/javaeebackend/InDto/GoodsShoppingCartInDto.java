package com.xagd.javaeebackend.InDto;

/**
 * TODO:此处写GoodsShoppingCartInDto类的描述
 *
 * @author shotray
 * @since 2021/12/29 21:16
 */

public class GoodsShoppingCartInDto {
    short goodsId;

    short count;

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    public void setCount(short count) {
        this.count = count;
    }

    public short getGoodsId() {
        return this.goodsId;
    }

    public short getCount() {
        return this.count;
    }

}

