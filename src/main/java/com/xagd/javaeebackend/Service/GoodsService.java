package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {
    GoodsEntity addGoods(GoodsEntity goods, MultipartFile[] files, Short userId);
}
