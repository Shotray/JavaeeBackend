package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.UserfavoriteEntity;
import com.xagd.javaeebackend.Repository.UserFavoritesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO:此处写UserFavoritesService类的描述
 *
 * @author shotray
 * @since 2021/12/4 1:00
 */

@Service
public class UserFavoritesService {
    @Resource
    private UserFavoritesRepository userFavoritesRepository;

    public UserfavoriteEntity addUserFavorites(UserfavoriteEntity userfavoriteEntity){
        return userFavoritesRepository.save(userfavoriteEntity);
    }
}

