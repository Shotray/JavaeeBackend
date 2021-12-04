package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.MeService;

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
}
