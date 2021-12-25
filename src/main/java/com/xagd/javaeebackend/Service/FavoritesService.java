package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * TODO:此处写FavoriteService类的描述
 *
 * @author shotray
 * @since 2021/12/3 16:31
 */

public interface FavoritesService {
    FavoritesEntity addFavorites(FavoritesInDto favoritesInDto);

    ArrayList<FavoritesEntity> getFavoritesEntityByUserId(short userId);

    FavoritesGoodsOutDto getFavoritesGoods();
}

