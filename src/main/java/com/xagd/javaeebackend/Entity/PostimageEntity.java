package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "postimage", schema = "db", catalog = "")
@IdClass(PostimageEntityPK.class)
public class PostimageEntity {
    private short postId;
    private String imageUrl;

    @Id
    @Column(name = "post_id")
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "image_url")
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

        PostimageEntity that = (PostimageEntity) o;

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
