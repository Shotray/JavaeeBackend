package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.internal.OSSUtils;
import com.xagd.javaeebackend.Entity.*;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import com.xagd.javaeebackend.OutDto.MyGoodsOutDto;
import com.xagd.javaeebackend.OutDto.GoodsDetailedDto;
import com.xagd.javaeebackend.OutDto.GoodsSearchOutDto;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Repository.*;
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

    @Resource
    private UserRepository userRepository;

    @Resource
    private ShoppingCartRepository shoppingCartRepository;


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
    public List<MyGoodsOutDto> getGoods(Short userId) {
        List<MyGoodsOutDto> myGoods = new ArrayList<MyGoodsOutDto>();
        GoodsEntity[] goods = this.goodsRepository.getGoodsEntitiesByUserId(userId);
        for (GoodsEntity good : goods) {
            List<GoodsimageEntity> goodsImage = this.goodsImageRepository.getGoodsimageEntitiesByGoodsId(good.getGoodsId());
            MyGoodsOutDto tmp = new MyGoodsOutDto();
            tmp.setImage(goodsImage.get(0).getImage());
            tmp.setGoodsEntity(good);
            myGoods.add(tmp);
        }
        return myGoods;
    }

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
    public GoodsEntity deleteGood(Short id) {
        GoodsEntity good = this.goodsRepository.getById(id);
        this.goodsRepository.deleteById(id);
        return good;
    }


    @Override
    public GoodsDetailedDto getGoodsDetailed(Short goodsId) {
        GoodsDetailedDto goodsDetailedDto = new GoodsDetailedDto();

        GoodsEntity goodsEntity = goodsRepository.getById(goodsId);
        UserEntity userEntity = userRepository.getById(goodsEntity.getUserId());
        List<GoodsimageEntity> goodsimageEntity = goodsImageRepository.getGoodsimageEntitiesByGoodsId(goodsId);
        List<String> url = new ArrayList<>();
        for(GoodsimageEntity item: goodsimageEntity){
            url.add(item.getImage());
        }

        goodsDetailedDto.setUserName(userEntity.getUserName());
        goodsDetailedDto.setUserImage(userEntity.getUserImage());
        goodsDetailedDto.setGoodsName(goodsEntity.getGoodsName());
        goodsDetailedDto.setPrice(goodsEntity.getGoodsPrice());
        goodsDetailedDto.setLikes(goodsEntity.getGoodsFavorite());
        goodsDetailedDto.setDescription(goodsEntity.getGoodsIntroduction());
        goodsDetailedDto.setCategory(goodsEntity.getGoodsCategory());
        goodsDetailedDto.setGoodsImage(url);

        return goodsDetailedDto;
    }

    @Override
    public ShoppingcartEntity addGoodsToShoppingCart(Short goodsId,Short count) {
        Short userId = (short) StpUtil.getLoginIdAsInt();
        ShoppingcartEntity shoppingcartEntity = new ShoppingcartEntity();
        shoppingcartEntity.setShoppingCartId(userId);
        shoppingcartEntity.setGoodsId(goodsId);
        shoppingcartEntity.setCount(count);
        return shoppingCartRepository.save(shoppingcartEntity);
    }


}
