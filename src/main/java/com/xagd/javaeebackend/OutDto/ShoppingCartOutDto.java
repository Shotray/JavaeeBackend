package com.xagd.javaeebackend.OutDto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ShoppingCartOutDto {
    private short goodsId;
    private short userId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private short count;
    private String image;
    private short sellNum;

    public short getSellNum() {
        return sellNum;
    }

    public void setSellNum(short sellNum) {
        this.sellNum = sellNum;
    }

    public short getUserId() { return userId; }

    public void setUserId(short userId) { this.userId = userId; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
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

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingCartOutDto{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", count=" + count +
                ", image='" + image + '\'' +
                '}';
    }
}
