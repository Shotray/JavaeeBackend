package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FavoritesGoodsViewRepository extends JpaRepository<FavoritesGoodsViewEntity, FavoritesGoodsViewEntityPK> {
    ArrayList<FavoritesGoodsViewEntity> findFavoritesGoodsViewEntityByFavoritesId(short favoritesId);

}
