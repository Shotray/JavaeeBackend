package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "goodsuser", schema = "db", catalog = "")
@IdClass(GoodsuserEntityPK.class)
public class GoodsuserEntity {
    private short goodsId;
    private short userId;

    @Id
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "user_id")
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

        GoodsuserEntity that = (GoodsuserEntity) o;

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
