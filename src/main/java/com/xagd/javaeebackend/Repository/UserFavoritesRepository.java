package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.UserfavoriteEntity;
import com.xagd.javaeebackend.Entity.UserfavoriteEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO:此处写UserFavoritesRepository类的描述
 *
 * @author shotray
 * @since 2021/12/4 1:00
 */

public interface UserFavoritesRepository extends JpaRepository<UserfavoriteEntity, UserfavoriteEntityPK> {

}

