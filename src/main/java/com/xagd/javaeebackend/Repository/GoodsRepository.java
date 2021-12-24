package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Short> {
    GoodsEntity[] getGoodsEntitiesByUserId(Short userId);


}
