package com.xagd.javaeebackend.OutDto;

import java.math.BigDecimal;

public class OrderGoodsOutDto {
    private short orderId;
    private short goodsId;
    private short sellerId;
    private short count;
    private BigDecimal totalPrice;
    private String location;
    private short status;
    private String goodsName;
    private BigDecimal goodsPrice;
    private short sellNum;
    private byte sellStatus;
    private String goodsIntroduction;

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    public short getSellerId() {
        return sellerId;
    }

    public void setSellerId(short sellerId) {
        this.sellerId = sellerId;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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

    public short getSellNum() {
        return sellNum;
    }

    public void setSellNum(short sellNum) {
        this.sellNum = sellNum;
    }

    public byte getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(byte sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }
}
