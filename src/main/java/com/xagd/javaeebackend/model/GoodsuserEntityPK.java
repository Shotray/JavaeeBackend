package com.xagd.javaeebackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsuserEntityPK implements Serializable {
    private short goodsId;
    private short userId;

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "user_id")
    @Id
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsuserEntityPK that = (GoodsuserEntityPK) o;

        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) goodsId;
        result = 31 * result + (int) userId;
        return result;
    }
}
