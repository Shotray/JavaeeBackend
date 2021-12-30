package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostimageEntityRepository extends JpaRepository<PostImageEntity, Short> {
    List<PostImageEntity> getAllByPostId(Short postId);
}