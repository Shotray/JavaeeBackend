package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "post", schema = "db", catalog = "")
public class PostEntity {
    private short postId;
    private Short userId;
    private Timestamp postDate;
    private String postIntroduction;
    private Short postPrice;

    @Id
    @Column(name = "post_id")
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "user_id")
    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "post_date")
    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    @Basic
    @Column(name = "post_introduction")
    public String getPostIntroduction() {
        return postIntroduction;
    }

    public void setPostIntroduction(String postIntroduction) {
        this.postIntroduction = postIntroduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (postId != that.postId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (postDate != null ? !postDate.equals(that.postDate) : that.postDate != null) return false;
        if (postIntroduction != null ? !postIntroduction.equals(that.postIntroduction) : that.postIntroduction != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) postId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (postDate != null ? postDate.hashCode() : 0);
        result = 31 * result + (postIntroduction != null ? postIntroduction.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "post_price")
    public Short getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Short postPrice) {
        this.postPrice = postPrice;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", postDate=" + postDate +
                ", postIntroduction='" + postIntroduction + '\'' +
                ", postPrice=" + postPrice +
                '}';
    }
}
