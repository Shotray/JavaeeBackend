package com.xagd.javaeebackend.OutDto;

import java.math.BigDecimal;

public class GoodsSearchOutDto {
    private short userId;
    private short goodsId;
    private byte goodsCategory;
    private String goodsName;
    private BigDecimal goodsPrice;
    private short goodsFavorite;
    private String userImage;
    private String userNickname;
    private String image;

    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    public byte getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(byte goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public short getGoodsFavorite() {
        return goodsFavorite;
    }

    public void setGoodsFavorite(short goodsFavorite) {
        this.goodsFavorite = goodsFavorite;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
