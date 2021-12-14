package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.Repository.FavoritesGoodsViewRepository;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import com.xagd.javaeebackend.Service.FavoritesGoodsViewService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * TODO:此处写FavoritesGoodsViewImpl类的描述
 *
 * @author shotray
 * @since 2021/12/12 22:24
 */

@Service
public class FavoritesGoodsViewImpl implements FavoritesGoodsViewService {
    @Resource
    FavoritesGoodsViewRepository favoritesGoodsViewRepository;


    @Override
    public ArrayList<FavoritesGoodsViewEntity> getGoodsInfoByFavoritesId(short favoritesId) {
        ArrayList<FavoritesGoodsViewEntity> favoritesGoodsViewEntities = new ArrayList<>();
        favoritesGoodsViewEntities = favoritesGoodsViewRepository.findFavoritesGoodsViewEntityByFavoritesId(favoritesId);
        return favoritesGoodsViewEntities;
    }
}

