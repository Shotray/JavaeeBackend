package com.xagd.javaeebackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ShoppingcartEntityPK implements Serializable {
    private short shoppingCartId;
    private short goodsId;

    @Column(name = "shopping_cart_id")
    @Id
    public short getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(short shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Column(name = "goods_id")
    @Id
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingcartEntityPK that = (ShoppingcartEntityPK) o;

        if (shoppingCartId != that.shoppingCartId) return false;
        if (goodsId != that.goodsId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) shoppingCartId;
        result = 31 * result + (int) goodsId;
        return result;
    }
}
