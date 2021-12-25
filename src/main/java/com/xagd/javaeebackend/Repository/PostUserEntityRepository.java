package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PostUserEntityRepository extends JpaRepository<PostUserEntity, Short> {
    PostUserEntity getByPostId(Short postId);
}