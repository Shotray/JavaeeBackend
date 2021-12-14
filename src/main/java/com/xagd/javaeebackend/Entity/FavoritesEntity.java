package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

/**
 * TODO:此处写FavoritesEntity类的描述
 *
 * @author shotray
 * @since 2021/12/12 16:02
 */

@Entity
@Table(name = "favorites", schema = "db", catalog = "")
public class FavoritesEntity {
    private short favoritesId;
    private String favoritesName;
    private Short userId;

    @Id
    @Column(name = "favorites_id")
    public short getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Basic
    @Column(name = "favorites_name")
    public String getFavoritesName() {
        return favoritesName;
    }

    public void setFavoritesName(String favoritesName) {
        this.favoritesName = favoritesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoritesEntity that = (FavoritesEntity) o;

        if (favoritesId != that.favoritesId) return false;
        if (favoritesName != null ? !favoritesName.equals(that.favoritesName) : that.favoritesName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) favoritesId;
        result = 31 * result + (favoritesName != null ? favoritesName.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "user_id")
    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }
}

