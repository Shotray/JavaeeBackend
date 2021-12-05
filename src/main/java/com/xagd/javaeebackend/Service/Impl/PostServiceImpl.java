package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.Repository.PostRepository;
import com.xagd.javaeebackend.Repository.PostUserEntityRepository;
import com.xagd.javaeebackend.Service.PostService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Resource
    private PostUserEntityRepository postUserEntityRepository;

    @Override
    public PostEntity addPost(PostEntity post) {
        return postRepository.save(post);
    }

    @Override
    public List<PostUserEntity> getPosts() {
        return postUserEntityRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
    }
}
