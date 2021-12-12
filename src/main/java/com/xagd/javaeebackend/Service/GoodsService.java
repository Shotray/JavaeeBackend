package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface GoodsService {
    GoodsEntity addGoods(GoodsEntity goods, MultipartFile[] files, Short userId);

    ArrayList<GoodsCategoryOutDto> getGoodsByCategory(byte category);
}
