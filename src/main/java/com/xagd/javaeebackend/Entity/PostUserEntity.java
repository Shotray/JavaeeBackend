package com.xagd.javaeebackend.Entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Immutable
@Table(name = "post_user")
public class PostUserEntity {
    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "post_title", nullable = false, length = 50)
    private String postTitle;

    @Column(name = "post_date")
    private Instant postDate;

    @Column(name = "post_introduction", nullable = false)
    private String postIntroduction;

    @Column(name = "user_nickname", length = 30)
    private String userNickname;

    @Column(name = "user_image", nullable = false, length = 100)
    private String userImage;

    public String getUserImage() {
        return userImage;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getPostIntroduction() {
        return postIntroduction;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public Integer getPostId() {
        return postId;
    }
}