package com.xagd.javaeebackend.repository;

import com.xagd.javaeebackend.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import reactor.util.annotation.Nullable;


public interface UserRepository extends JpaRepository<UserEntity, Short> {

    boolean existsUserEntityByUserPhone(String userPhone);

    boolean existsUserEntityByUserEmail(String userEmail);

    boolean existsUserEntityByUserName(String userName);

    @Nullable
    UserEntity findUserEntityByUserNameOrUserPhone(String userName, String userPhone);
}
