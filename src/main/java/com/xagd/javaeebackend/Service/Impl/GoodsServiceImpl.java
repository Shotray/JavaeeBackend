package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.GoodsImageService;
import com.xagd.javaeebackend.Service.GoodsService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsRepository goodsRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;


    @Override
    public GoodsEntity addGoods(GoodsEntity goods, MultipartFile[] files, Short userId) {
        goods.setUserId(userId);
        GoodsEntity addedGoods = goodsRepository.save(goods);

        for (MultipartFile file : files){
            String url = OSSUtil.uploadFile(file, "goodsimage" + addedGoods.getGoodsId());
            GoodsimageEntity goodsImageEntity = new GoodsimageEntity();
            goodsImageEntity.setGoodsId(addedGoods.getGoodsId());
            goodsImageEntity.setImage(url);
            goodsImageRepository.save(goodsImageEntity);
        }
        return addedGoods;
    }
}
