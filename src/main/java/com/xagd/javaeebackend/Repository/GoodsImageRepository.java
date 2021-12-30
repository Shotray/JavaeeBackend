package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.*;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsImageRepository extends JpaRepository<GoodsImageEntity, GoodsImageEntityPK> {
    @Override
    <S extends GoodsImageEntity> Optional<S> findOne(Example<S> example);

    List<GoodsImageEntity> getGoodsimageEntitiesByGoodsId(Short goodId);
}
