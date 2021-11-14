package com.xagd.javaeebackend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "browsehistory", schema = "db", catalog = "")
@IdClass(BrowsehistoryEntityPK.class)
public class BrowsehistoryEntity {
    private short userId;
    private short goodsId;
    private Timestamp time;

    @Id
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "time")
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

        BrowsehistoryEntity that = (BrowsehistoryEntity) o;

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
