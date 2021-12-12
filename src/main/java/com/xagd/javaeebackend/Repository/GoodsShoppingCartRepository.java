package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GoodsShoppingCartRepository extends JpaRepository<GoodsShoppingcartEntity, GoodsShoppingcartEntityPK> {

    ArrayList<GoodsShoppingcartEntity> findAllByShoppingCartId(short shoppingCartId);
}
