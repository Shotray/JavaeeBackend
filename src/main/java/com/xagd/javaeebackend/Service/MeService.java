package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import org.springframework.web.multipart.MultipartFile;

public interface MeService {
    UserEntity updateInfo(MeEditDto meEditDto);
    UserEntity updateImage(MultipartFile[] files);
}
