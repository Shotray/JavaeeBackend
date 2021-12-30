package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;

import java.util.ArrayList;

public interface ShoppingCartService {
    ShoppingcartEntity addGoods(ShoppingcartEntity shoppingCart);

    ArrayList<ShoppingCartOutDto> findAllByShoppingCartId(short shoppingCartId);

    void deleteGoods(ShoppingcartEntity entity);

    void changeCount(short shoppingCartId, short goodsId, short count);
}
