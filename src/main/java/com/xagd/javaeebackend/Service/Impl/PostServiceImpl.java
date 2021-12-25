package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.OutDto.PostDetailOutDto;
import com.xagd.javaeebackend.Repository.PostRepository;
import com.xagd.javaeebackend.Repository.PostUserEntityRepository;
import com.xagd.javaeebackend.Repository.PostimageEntityRepository;
import com.xagd.javaeebackend.Service.PostService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Resource
    private PostimageEntityRepository postImageRepository;

    @Resource
    private PostUserEntityRepository postUserEntityRepository;

    @SaCheckLogin
    @Override
    public PostEntity addPost(PostEntity postEntity, MultipartFile[] files) {
        postEntity.setUserId((short) StpUtil.getLoginIdAsInt());
        System.out.println(postEntity);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        postEntity.setPostDate(time);
        PostEntity postEntity1 = postRepository.save(postEntity);
        System.out.println(postEntity1);

        for (MultipartFile file: files) {
            String url = OSSUtil.uploadFile(file, "postimage" + postEntity1.getPostId());
            PostimageEntity postimageEntity = new PostimageEntity();
            postimageEntity.setPostId(postEntity1.getPostId());
            postimageEntity.setImageUrl(url);
            postImageRepository.save(postimageEntity);
        }
        return postEntity1;
    }

    @Override
    public List<PostUserEntity> getPosts() {
        return postUserEntityRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
    }

    @Override
    public List<PostUserEntity> getPosts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "postDate"));
        return postUserEntityRepository.findAll(pageable).getContent();
    }

    @Override
    public PostEntity[] getPosts(Short userId) {
        return this.postRepository.getPostEntitiesByUserId(userId);
    }

    @Override
    public PostEntity deletePost(Short id) {
        PostEntity post = this.postRepository.getById(id);
        this.postRepository.deleteById(id);
        return post;
    }

    @Override
    public PostDetailOutDto getPostDetailById(Short postId) {
        PostEntity post = this.postRepository.getPostEntityByPostId(postId);
        List<PostimageEntity> postImages = this.postImageRepository.getAllByPostId(postId);
        PostUserEntity postUser = this.postUserEntityRepository.getByPostId(postId);
        PostDetailOutDto postDetail = new PostDetailOutDto();
        postDetail.setPostUser(postUser);
        postDetail.setPost(post);
        postDetail.setPostImages(postImages);
        return postDetail;
    }
}
