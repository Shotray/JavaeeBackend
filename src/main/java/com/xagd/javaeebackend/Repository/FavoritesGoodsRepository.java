package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoritesGoodsEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesGoodsRepository extends JpaRepository<FavoritesGoodsEntity, FavoritesGoodsEntityPK> {
    void deleteFavoritesGoodsEntitiesByFavoritesId(short favoritesId);

    void deleteFavoritesGoodsEntityByFavoritesIdAndGoodsId(short favoritesId,short goodsId);

    List<FavoritesGoodsEntity> getFavoritesGoodsEntitiesByGoodsId(short goodsId);

    List<FavoritesGoodsEntity> getFavoritesGoodsEntitiesByFavoritesId(short favoriteId);

    void deleteAllByGoodsId(short id);
}
