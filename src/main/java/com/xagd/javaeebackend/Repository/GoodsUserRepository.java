package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.GoodsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface GoodsUserRepository extends JpaRepository<GoodsUserEntity, Short>{

    ArrayList<GoodsUserEntity> findAllByGoodsCategory(byte category);
}
