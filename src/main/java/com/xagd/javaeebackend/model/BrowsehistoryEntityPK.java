package com.xagd.javaeebackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class BrowsehistoryEntityPK implements Serializable {
    private short userId;
    private short goodsId;
    private Timestamp time;

    @Column(name = "user_id")
    @Id
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "time")
    @Id
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrowsehistoryEntityPK that = (BrowsehistoryEntityPK) o;

        if (userId != that.userId) return false;
        if (goodsId != that.goodsId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) userId;
        result = 31 * result + (int) goodsId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
