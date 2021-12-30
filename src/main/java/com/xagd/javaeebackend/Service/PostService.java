package com.xagd.javaeebackend.Service;


import com.xagd.javaeebackend.Entity.CommentEntity;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.OutDto.PostCommentOutDto;
import com.xagd.javaeebackend.OutDto.PostDetailOutDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    PostEntity addPost(PostEntity post, MultipartFile[] files);

    List<PostUserEntity> getPosts();
    PostEntity[] getPosts(Short userId);

    List<PostUserEntity> getPosts(int pageNo, int pageSize);

    PostEntity deletePost(Short id);

    PostDetailOutDto getPostDetailById(Short postId);

    CommentEntity addComment(short postId, short userId, String comment);

    List<PostCommentOutDto> getPostComment(short postId);
}
