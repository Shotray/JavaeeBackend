package com.xagd.javaeebackend.Controller;

import com.xagd.javaeebackend.Entity.FavoriteEntity;
import com.xagd.javaeebackend.Entity.UserfavoriteEntity;
import com.xagd.javaeebackend.Service.FavoriteService;
import com.xagd.javaeebackend.Service.UserFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
* TODO:此处写FavoriteController类的描述
* @author shotray
* @since 2021-12-03 14:57
*/

@RestController
@RequestMapping(value = "favorites")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    UserFavoritesService userFavoritesService;

    @RequestMapping(value = "createFavorites",method = RequestMethod.POST)
    public void createFavoirtes(String favoritesName, short userId){
        FavoriteEntity temp = new FavoriteEntity();
        temp.setFavoritesName(favoritesName);
        favoriteService.addFavorites(temp);
        short favoriteId = temp.getFavoritesId();

        UserfavoriteEntity userfavoriteEntity = new UserfavoriteEntity();
        userfavoriteEntity.setFavoritesId(favoriteId);
        userfavoriteEntity.setUserId(userId);
        userFavoritesService.addUserFavorites(userfavoriteEntity);
    }

    @RequestMapping(value = "getFavoritesContent",method = RequestMethod.GET)
    public List<FavoriteEntity> getFavoritesContent(short userId){
        List<FavoriteEntity> favoriteEntityList = new ArrayList<>();
        return favoriteEntityList;
    }
}

