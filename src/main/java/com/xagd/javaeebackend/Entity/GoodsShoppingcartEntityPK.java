package com.xagd.javaeebackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsShoppingcartEntityPK implements Serializable {
    private short goodsId;
    private short shoppingCartId;

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "shopping_cart_id")
    @Id
    public short getshoppingCartId() {
        return shoppingCartId;
    }

    public void setshoppingCartId(short shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsShoppingcartEntityPK that = (GoodsShoppingcartEntityPK) o;

        if (goodsId != that.goodsId) return false;
        if (shoppingCartId != that.shoppingCartId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) goodsId;
        result = 31 * result + (int) shoppingCartId;
        return result;
    }
}
