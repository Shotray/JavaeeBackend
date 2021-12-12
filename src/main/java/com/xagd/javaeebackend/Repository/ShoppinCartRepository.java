package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntityPK;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ShoppinCartRepository extends JpaRepository<ShoppingcartEntity, ShoppingcartEntityPK> {

    @Override
    ArrayList<ShoppingcartEntity> findAll();

    @Override
    void delete(ShoppingcartEntity entity);
}
