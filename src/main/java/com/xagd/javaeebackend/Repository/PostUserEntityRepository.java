package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostUserEntityRepository extends JpaRepository<PostUserEntity, Short> {
    List<PostUserEntity> getPostUserEntitiesByPostId(Short postId);
}