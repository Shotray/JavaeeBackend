package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.*;
import com.xagd.javaeebackend.OutDto.PostCommentOutDto;
import com.xagd.javaeebackend.OutDto.PostDetailOutDto;
import com.xagd.javaeebackend.Repository.*;
import com.xagd.javaeebackend.Service.PostService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.xagd.javaeebackend.Entity.PostImageEntity;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Resource
    private PostimageEntityRepository postImageRepository;

    @Resource
    private PostUserEntityRepository postUserEntityRepository;

    @Resource
    private CommentRepository commentRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public PostEntity addPost(PostEntity postEntity, MultipartFile[] files, Short userId) {
        postEntity.setUserId(userId);
        System.out.println(postEntity);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        postEntity.setPostDate(time);
        PostEntity postEntity1 = postRepository.save(postEntity);
        System.out.println(postEntity1);

        for (MultipartFile file: files) {
            String url = OSSUtil.uploadFile(file, "postimage" + postEntity1.getPostId());
            PostImageEntity postimageEntity = new PostImageEntity();
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
        List<PostImageEntity> postImages = this.postImageRepository.getAllByPostId(id);
        for (PostImageEntity postImage: postImages) {
            this.postImageRepository.delete(postImage);
        }
        PostEntity post = this.postRepository.getById(id);
        this.postRepository.deleteById(id);
        return post;
    }

    @Override
    public PostDetailOutDto getPostDetailById(Short postId) {
        PostEntity post = this.postRepository.getPostEntityByPostId(postId);
        System.out.println(post);
        List<PostImageEntity> postImages = this.postImageRepository.getAllByPostId(postId);
        System.out.println(postImages.size());
        List<PostUserEntity> postUsers = postUserEntityRepository.findAll(Sort.by(Sort.Direction.DESC, "postDate"));
        PostDetailOutDto postDetail = new PostDetailOutDto();
        for (PostUserEntity postUser: postUsers) {
            if (postUser.getPostId() == (int)postId) {
                postDetail.setPostUser(postUser);
                break;
            }
        }
        postDetail.setPost(post);
        postDetail.setPostImages(postImages);
        System.out.println(postDetail);
        return postDetail;
    }

    @Override
    public CommentEntity addComment(short postId, short userId, String comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setPostId(postId);
        commentEntity.setUserId(userId);
        commentEntity.setCommentContent(comment);
        return commentRepository.save(commentEntity);
    }

    @Override
    public List<PostCommentOutDto> getPostComment(short postId) {
        List<CommentEntity> list = commentRepository.findAllByPostIdOrderByCommentDateDesc(postId);
        List<PostCommentOutDto> postCommentOutDtoList = new ArrayList<>();
        for (CommentEntity commentEntity: list){
            PostCommentOutDto postCommentOutDto = new PostCommentOutDto();
            UserEntity user = userRepository.findUserEntityByUserId(commentEntity.getUserId());
            postCommentOutDto.setUserName(user.getUserNickname());
            postCommentOutDto.setUserImage(user.getUserImage());
            postCommentOutDto.setComment(commentEntity.getCommentContent());
            postCommentOutDtoList.add(postCommentOutDto);
        }
        return postCommentOutDtoList;
    }
}
