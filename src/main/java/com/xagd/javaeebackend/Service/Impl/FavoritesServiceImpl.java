package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import com.xagd.javaeebackend.Service.FavoritesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * TODO:此处写FavoritesServiceImpl类的描述
 *
 * @author shotray
 * @since 2021/12/12 19:29
 */

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Resource
    private FavoritesRepository favoritesRepository;

    @Override
    public FavoritesEntity addFavorites(FavoritesEntity favoritesEntity, short userId) {
        favoritesEntity.setUserId(userId);
        FavoritesEntity addedFavorites = favoritesRepository.save(favoritesEntity);
        return addedFavorites;
    }

    @Override
    public ArrayList<FavoritesEntity> getFavoritesEntityByUserId(short userId) {
        ArrayList<FavoritesEntity> favoritesEntities = new ArrayList<>();
        favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        return favoritesEntities;
    }
}

