package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.GoodsuserEntity;
import com.xagd.javaeebackend.Entity.GoodsuserEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsUserRepository extends JpaRepository<GoodsuserEntity, GoodsuserEntityPK> {
}
