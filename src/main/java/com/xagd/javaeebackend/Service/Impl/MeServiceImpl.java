package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.MeService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

public class MeServiceImpl implements MeService {
    @Resource
    private UserRepository userRepository;

    @SaCheckLogin
    @Override
    public UserEntity updateInfo(MeEditDto meEditDto, MultipartFile[] files) {
        UserEntity user = this.userRepository.findUserEntityByUserId((short) StpUtil.getLoginIdAsInt());
        user.setUserNickname(meEditDto.getUserNickName());
        user.setUserPhone(meEditDto.getUserPhone());
        user.setUserName(meEditDto.getUserRealName());
        user.setUserSex(meEditDto.getUserGender());
        MultipartFile file = files[0];
        String url = OSSUtil.uploadFile(file, "userimage" + user.getUserId());
        user.setUserImage(url);
        this.userRepository.save(user);
        return user;
    }
}
