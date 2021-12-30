package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MeService {
    UserEntity updateUserEntity(String userId, String userRealName, String userNickName, String userImageUrl, String userGrade, String userMajor);

    UserEntity updateImage(MultipartFile[] files);

    UserEntity updateInfo(UserEntity userEntity);
}
