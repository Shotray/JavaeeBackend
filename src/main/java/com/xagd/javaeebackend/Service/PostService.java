package com.xagd.javaeebackend.Service;


import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    public PostEntity addPost(PostEntity post, MultipartFile[] files);

    public List<PostUserEntity> getPosts();
    public PostEntity[] getPosts(Short userId);

    public List<PostUserEntity> getPosts(int pageNo, int pageSize);

    public PostEntity deletePost(Short id);
}
