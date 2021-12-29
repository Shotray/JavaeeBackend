package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsEntity;
import com.xagd.javaeebackend.InDto.FavoritesGoodsInDto;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO:此处写FavoriteService类的描述
 *
 * @author shotray
 * @since 2021/12/3 16:31
 */

public interface FavoritesService {
    FavoritesEntity addFavorites(FavoritesInDto favoritesInDto);

    List<FavoritesEntity> getFavoritesEntityByUserId();

    FavoritesGoodsOutDto getFavoritesGoods();

    void deleteFavorites(short favoriteId);

    List<HashMap<String,String>> getFavorites();

    FavoritesGoodsEntity addFavoritesGoods(FavoritesGoodsInDto favoritesGoodsInDto);

    void deleteFavoritesGoods(Short goodsId);

    Boolean checkFavoritesGoods(Short goodsId);
}

