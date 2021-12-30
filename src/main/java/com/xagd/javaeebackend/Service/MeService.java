package com.xagd.javaeebackend.Service;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.web.multipart.MultipartFile;

public interface MeService {
    UserEntity updateInfo(MeEditDto meEditDto, MultipartFile[] files);
}
