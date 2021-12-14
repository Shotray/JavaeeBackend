package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;

import java.util.ArrayList;

public interface FavoritesGoodsViewService {
    ArrayList<FavoritesGoodsViewEntity> getGoodsInfoByFavoritesId(short favoritesId);
}
