package com.xagd.javaeebackend.Service;


import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;

import java.util.List;

public interface PostService {
    PostEntity addPost(PostEntity post);

    List<PostUserEntity> getPosts();

    List<PostUserEntity> getPosts(int pageNo, int pageSize);
}
