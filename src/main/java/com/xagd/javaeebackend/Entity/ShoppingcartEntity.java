package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "shoppingcart", schema = "db", catalog = "")
@IdClass(ShoppingcartEntityPK.class)
public class ShoppingcartEntity {
    private short shoppingCartId;
    private short goodsId;

    @Id
    @Column(name = "shopping_cart_id")
    public short getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(short shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Id
    @Column(name = "goods_id")
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

        ShoppingcartEntity that = (ShoppingcartEntity) o;

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
