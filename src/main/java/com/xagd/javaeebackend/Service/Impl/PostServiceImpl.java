package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Repository.PostRepository;
import com.xagd.javaeebackend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    public PostEntity addPost(PostEntity post) {
        return postRepository.save(post);
    }


}
