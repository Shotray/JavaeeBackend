package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "goodsimage", schema = "db", catalog = "")
@IdClass(GoodsimageEntityPK.class)
public class GoodsimageEntity {
    private short goodsId;
    private String image;

    @Id
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "image")
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

        GoodsimageEntity that = (GoodsimageEntity) o;

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
