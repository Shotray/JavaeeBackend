package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "userfavorite", schema = "db", catalog = "")
@IdClass(UserfavoriteEntityPK.class)
public class UserfavoriteEntity {
    private short favoritesId;
    private short userId;

    @Id
    @Column(name = "favorites_id")
    public short getFavoritesId() {
        return favoritesId;
    }

    public void setFavoritesId(short favoritesId) {
        this.favoritesId = favoritesId;
    }

    @Id
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserfavoriteEntity that = (UserfavoriteEntity) o;

        if (favoritesId != that.favoritesId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) favoritesId;
        result = 31 * result + (int) userId;
        return result;
    }
}
