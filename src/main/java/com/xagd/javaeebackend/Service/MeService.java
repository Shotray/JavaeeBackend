package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.UserEntity;

public interface MeService {
    UserEntity updateUserEntity(String userId, String userRealName, String userNickName, String userImageUrl, String userGrade, String userMajor);
}
