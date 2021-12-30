package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsImageEntity;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Service.GoodsImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsImageServiceImpl implements GoodsImageService {
    @Resource
    private GoodsImageRepository goodsImageRepository;

    @Override
    public GoodsImageEntity addGoodsImage(GoodsImageEntity goodsImage) {
        return goodsImageRepository.save(goodsImage);
    }

}
