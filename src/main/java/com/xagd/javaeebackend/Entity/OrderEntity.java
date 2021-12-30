package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "`order`", schema = "db", catalog = "")
public class OrderEntity {
    private short orderId;
    private short goodsId;
    private short userId;
    private short count;
    private BigDecimal totalPrice;
    private Timestamp orderDate;
    private String location;

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
    @Column(name = "count")
    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    @Basic
    @Column(name = "total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "order_date")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;
        if (count != that.count) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (int) goodsId;
        result = 31 * result + (int) userId;
        result = 31 * result + (int) count;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
