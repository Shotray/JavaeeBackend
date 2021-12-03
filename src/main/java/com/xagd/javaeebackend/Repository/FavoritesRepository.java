package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<FavoriteEntity,Integer> {
}
