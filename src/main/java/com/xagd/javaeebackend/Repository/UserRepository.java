package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.util.annotation.Nullable;


public interface UserRepository extends JpaRepository<UserEntity, Short> {

    boolean existsUserEntityByUserPhone(String userPhone);

    boolean existsUserEntityByUserEmail(String userEmail);

    boolean existsUserEntityByUserName(String userName);

    @Nullable
    UserEntity findUserEntityByUserNameOrUserPhone(String userName, String userPhone);
}
