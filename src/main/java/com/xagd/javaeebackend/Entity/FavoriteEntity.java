package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "favorite", schema = "db", catalog = "")
public class FavoriteEntity {
    private short favoritesId;
    private String favoritesName;

    @Id
    @Column(name = "favorites_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

        FavoriteEntity that = (FavoriteEntity) o;

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
}
