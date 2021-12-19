package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.MeService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

public class MeServiceImpl implements MeService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity updateUserEntity(String userId, String userRealName, String userNickName, String userImageUrl, String userGrade, String userMajor) {
        UserEntity user2 = userRepository.findUserEntityByUserId(Short.valueOf(userId));
        user2.setUserImage(userImageUrl);
        user2.setUserName(userRealName);
        user2.setUserNickname(userNickName);
        userRepository.save(user2);
        return user2;
    }

    @SaCheckLogin
    @Override
    public UserEntity updateImage(MultipartFile[] files) {
        UserEntity user = userRepository.findUserEntityByUserId((short)StpUtil.getLoginIdAsInt());
        String url = OSSUtil.uploadFile(files[0], "user" + StpUtil.getLoginIdAsInt());
        user.setUserImage(url);
        this.userRepository.save(user);
        return user;
    }

    @SaCheckLogin
    @Override
    public UserEntity updateInfo(UserEntity userEntity) {
        this.userRepository.save(userEntity);
        return userEntity;
    }
}
