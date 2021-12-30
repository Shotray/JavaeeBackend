package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.MeService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class MeServiceImpl implements MeService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity updateInfo(MeEditDto meEditDto, Short userId) {
        UserEntity user = this.userRepository.findUserEntityByUserId(userId);
        user.setUserNickname(meEditDto.getUserNickname());
        user.setUserPhone(meEditDto.getUserPhone());
        user.setUserName(meEditDto.getUserName());
        user.setUserSex(meEditDto.getUserSex());
        this.userRepository.save(user);
        return user;
    }

    @SaCheckLogin
    @Override
    public UserEntity updateImage(MultipartFile[] files) {
        UserEntity user = this.userRepository.findUserEntityByUserId((short) StpUtil.getLoginIdAsInt());
        String url = OSSUtil.uploadFile(files[0], "userimage" + user.getUserId());
        user.setUserImage(url);
        this.userRepository.save(user);
        return user;
    }
}
