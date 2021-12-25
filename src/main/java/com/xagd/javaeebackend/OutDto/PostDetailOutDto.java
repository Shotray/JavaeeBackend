package com.xagd.javaeebackend.OutDto;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;

import java.util.List;

public class PostDetailOutDto {
    PostEntity post;
    List<PostimageEntity> postImages;

    public PostUserEntity getPostUser() {
        return postUser;
    }

    public void setPostUser(PostUserEntity postUser) {
        this.postUser = postUser;
    }

    PostUserEntity postUser;

    public PostEntity getPost() {
        return post;
    }

    public List<PostimageEntity> getPostImages() {
        return postImages;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public void setPostImages(List<PostimageEntity> postImages) {
        this.postImages = postImages;
    }
}
