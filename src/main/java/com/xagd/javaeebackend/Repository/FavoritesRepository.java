package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;

public interface FavoritesRepository extends JpaRepository<FavoritesEntity,Short> {
    ArrayList<FavoritesEntity> getFavoritesEntityByUserId(short userId);

    void deleteFavoritesEntityByFavoritesId(short favoritesId);

}
