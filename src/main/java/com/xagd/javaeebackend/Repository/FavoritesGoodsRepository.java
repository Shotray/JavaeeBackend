package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoritesGoodsEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesGoodsRepository extends JpaRepository<FavoritesGoodsEntity, FavoritesGoodsEntityPK> {
    void deleteFavoritesGoodsEntitiesByFavoritesId(short favoritesId);
}
