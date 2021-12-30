package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Short> {
    List<CommentEntity> findAllByPostIdOrderByCommentDateDesc(short postId);
}
