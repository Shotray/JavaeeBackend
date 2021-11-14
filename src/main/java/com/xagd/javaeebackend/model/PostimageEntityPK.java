package com.xagd.javaeebackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PostimageEntityPK implements Serializable {
    private short postId;
    private String imageUrl;

    @Column(name = "post_id")
    @Id
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Column(name = "image_url")
    @Id
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostimageEntityPK that = (PostimageEntityPK) o;

        if (postId != that.postId) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) postId;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
