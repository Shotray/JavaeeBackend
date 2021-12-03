package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Short> {
}