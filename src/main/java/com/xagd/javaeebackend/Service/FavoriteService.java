package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.FavoriteEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO:此处写FavoriteService类的描述
 *
 * @author shotray
 * @since 2021/12/3 16:31
 */

@Service
public class FavoriteService {
    @Resource
    private FavoritesRepository favoritesRepository;

    public FavoriteEntity addFavorites(FavoriteEntity favoriteEntity) {
        return favoritesRepository.save(favoriteEntity);
    }
}

