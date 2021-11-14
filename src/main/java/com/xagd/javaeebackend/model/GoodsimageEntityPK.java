package com.xagd.javaeebackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsimageEntityPK implements Serializable {
    private short goodsId;
    private String image;

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "image")
    @Id
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsimageEntityPK that = (GoodsimageEntityPK) o;

        if (goodsId != that.goodsId) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) goodsId;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
