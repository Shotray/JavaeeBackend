package com.xagd.javaeebackend.OutDto;

import com.xagd.javaeebackend.Entity.GoodsEntity;

public class MyGoodsOutDto {
    public GoodsEntity getGoodsEntity() {
        return goodsEntity;
    }

    public String getImage() {
        return image;
    }

    public void setGoodsEntity(GoodsEntity goodsEntity) {
        this.goodsEntity = goodsEntity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    GoodsEntity goodsEntity;
    String image;
}
