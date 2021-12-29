package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<PostEntity, Short>, JpaSpecificationExecutor<PostEntity> {
    PostEntity[] getPostEntitiesByUserId(Short userId);
    PostEntity getPostEntityByPostId(Short postId);
}