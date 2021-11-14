package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "order", schema = "db", catalog = "")
public class OrderEntity {
    private short orderId;
    private short goodsId;
    private short userId;
    private short receiveId;

    @Id
    @Column(name = "order_id")
    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "receive_id")
    public short getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(short receiveId) {
        this.receiveId = receiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;
        if (receiveId != that.receiveId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) goodsId;
        result = 31 * result + (int) userId;
        result = 31 * result + (int) receiveId;
        return result;
    }
}
