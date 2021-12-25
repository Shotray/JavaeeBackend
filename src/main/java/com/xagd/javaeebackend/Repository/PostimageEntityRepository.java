package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostimageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostimageEntityRepository extends JpaRepository<PostimageEntity, Short> {
    List<PostimageEntity> getAllByPostId(Short postId);
}