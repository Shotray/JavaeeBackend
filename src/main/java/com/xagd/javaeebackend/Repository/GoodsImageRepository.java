package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.*;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsImageRepository extends JpaRepository<GoodsimageEntity, GoodsimageEntityPK> {
    @Override
    <S extends GoodsimageEntity> Optional<S> findOne(Example<S> example);

    GoodsimageEntity getGoodsimageEntityByGoodsId(Short goodsId);
}
