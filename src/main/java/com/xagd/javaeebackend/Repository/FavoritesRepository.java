package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.List;

public interface FavoritesRepository extends JpaRepository<FavoritesEntity,Short> {
    List<FavoritesEntity> getFavoritesEntityByUserId(short userId);

    void deleteFavoritesEntityByFavoritesId(short favoritesId);

}
