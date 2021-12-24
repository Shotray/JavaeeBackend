package com.xagd.javaeebackend.Service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.internal.OSSUtils;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.GoodsUserEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import com.xagd.javaeebackend.OutDto.GoodsSearchOutDto;
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
        List<GoodsUserEntity> goodsUserEntityList =  goodsUserRepository.findAllByGoodsCategory(category);
        for(GoodsUserEntity goodsUserEntity: goodsUserEntityList){
            GoodsimageEntity goodsImage = getGoodsImageByGoodsId(goodsUserEntity.getGoodsId());
            GoodsCategoryOutDto goodsCategoryOutDto = modelMapper.map(goodsUserEntity, GoodsCategoryOutDto.class);
            goodsCategoryOutDto.setImage(goodsImage.getImage());
            res.add(goodsCategoryOutDto);
        }
        return res;
    }

    @Override
    public ArrayList<GoodsSearchOutDto> getGoodsByName(String name) {
        ArrayList<GoodsSearchOutDto> res = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<GoodsUserEntity> goodsUserEntityList = goodsUserRepository.findAllByGoodsNameIsContaining(name);
        for (GoodsUserEntity goodsUserEntity: goodsUserEntityList){
            GoodsimageEntity goodsImage = getGoodsImageByGoodsId(goodsUserEntity.getGoodsId());
            GoodsSearchOutDto goodsSearchOutDto = modelMapper.map(goodsUserEntity, GoodsSearchOutDto.class);
            goodsSearchOutDto.setImage(goodsImage.getImage());
            res.add(goodsSearchOutDto);
        }
        return res;
    }

    @Override
    public ArrayList<GoodsSearchOutDto> getGoodsByOwnerName(String ownerName) {
        ArrayList<GoodsSearchOutDto> res = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<GoodsUserEntity> goodsUserEntityList = goodsUserRepository.findAllByUserNicknameIsContaining(ownerName);
        for (GoodsUserEntity goodsUserEntity: goodsUserEntityList){
            GoodsimageEntity goodsImage = getGoodsImageByGoodsId(goodsUserEntity.getGoodsId());
            GoodsSearchOutDto goodsSearchOutDto = modelMapper.map(goodsUserEntity, GoodsSearchOutDto.class);
            goodsSearchOutDto.setImage(goodsImage.getImage());
            res.add(goodsSearchOutDto);
        }
        return res;
    }

    private GoodsimageEntity getGoodsImageByGoodsId(short goodsId){
        GoodsimageEntity goodsImage = new GoodsimageEntity();
        goodsImage.setGoodsId(goodsId);
        Example<GoodsimageEntity> example = Example.of(goodsImage);
        Optional<GoodsimageEntity> result = goodsImageRepository.findOne(example);
        return result.get();
    }

    @Override
    public GoodsEntity[] getGoods(Short userId) {
        return this.goodsRepository.getGoodsEntitiesByUserId(userId);
    }

    @Override
    public GoodsEntity deleteGood(Short id) {
        GoodsEntity good = this.goodsRepository.getById(id);
        this.goodsRepository.deleteById(id);
        return good;
    }
}
