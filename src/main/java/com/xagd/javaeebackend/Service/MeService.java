package com.xagd.javaeebackend.Service;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.web.multipart.MultipartFile;

public interface MeService {
    UserEntity updateUserEntity(String userId, String userRealName, String userNickName, String userImageUrl, String userGrade, String userMajor);

    UserEntity updateImage(MultipartFile file);

    UserEntity updateInfo(UserEntity userEntity);
}
