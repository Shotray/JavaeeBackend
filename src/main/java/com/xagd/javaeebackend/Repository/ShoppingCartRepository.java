package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingcartEntity, ShoppingcartEntityPK> {

    @Override
    List<ShoppingcartEntity> findAll();

    @Override
    void delete(ShoppingcartEntity entity);
}
