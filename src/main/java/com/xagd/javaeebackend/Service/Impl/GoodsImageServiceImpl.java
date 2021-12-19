package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Service.GoodsImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsImageServiceImpl implements GoodsImageService {
    @Resource
    private GoodsImageRepository goodsImageRepository;

    @Override
    public GoodsimageEntity addGoodsImage(GoodsimageEntity goodsImage) {
        return goodsImageRepository.save(goodsImage);
    }

}
