package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.GoodsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface GoodsUserRepository extends JpaRepository<GoodsUserEntity, Short>{

    List<GoodsUserEntity> findAllByGoodsCategory(byte category);

    // goodsName包含关键词
    List<GoodsUserEntity> findAllByGoodsNameIsContaining(String keyword);

    // userNickName包含关键词
    List<GoodsUserEntity> findAllByUserNicknameIsContaining(String ownerName);
}
