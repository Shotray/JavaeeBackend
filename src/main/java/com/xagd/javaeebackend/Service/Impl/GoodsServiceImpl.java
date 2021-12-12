package com.xagd.javaeebackend.Service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.internal.OSSUtils;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.GoodsUserEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Repository.GoodsUserRepository;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.GoodsImageService;
import com.xagd.javaeebackend.Service.GoodsService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsRepository goodsRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;

    @Resource
    private GoodsUserRepository goodsUserRepository;


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

    @Override
    public ArrayList<GoodsCategoryOutDto> getGoodsByCategory(byte category) {
        ArrayList<GoodsCategoryOutDto> res = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        ArrayList<GoodsUserEntity> goodsUserEntityList =  goodsUserRepository.findAllByGoodsCategory(category);
        for(GoodsUserEntity goodsUserEntity: goodsUserEntityList){
            GoodsimageEntity goodsImage = new GoodsimageEntity();
            goodsImage.setGoodsId(goodsUserEntity.getGoodsId());
            Example<GoodsimageEntity> example = Example.of(goodsImage);
            Optional<GoodsimageEntity> result = goodsImageRepository.findOne(example);
            GoodsCategoryOutDto goodsCategoryOutDto = modelMapper.map(goodsUserEntity, GoodsCategoryOutDto.class);
            goodsCategoryOutDto.setImage(result.get().getImage());
            res.add(goodsCategoryOutDto);
        }
        return res;
    }


}
