package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntityPK;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Repository.GoodsShoppingCartRepository;
import com.xagd.javaeebackend.Repository.ShoppingCartRepository;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;

    @Resource
    private GoodsShoppingCartRepository goodsShoppingCartRepository;

    @Override
    public ShoppingcartEntity addGoods(ShoppingcartEntity shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ArrayList<ShoppingCartOutDto> findAllByShoppingCartId(short shoppingCartId) {
        ArrayList<ShoppingCartOutDto> res = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<GoodsShoppingcartEntity> goodsShoppingCartArrayList =  goodsShoppingCartRepository.findAllByShoppingCartId(shoppingCartId);
        for(GoodsShoppingcartEntity goodsShoppingCart: goodsShoppingCartArrayList){
            GoodsimageEntity goodsImage = new GoodsimageEntity();
            goodsImage.setGoodsId(goodsShoppingCart.getGoodsId());
            Example<GoodsimageEntity> example = Example.of(goodsImage);
            Optional<GoodsimageEntity> result = goodsImageRepository.findOne(example);
            ShoppingCartOutDto shoppingCartOutDto = modelMapper.map(goodsShoppingCart, ShoppingCartOutDto.class);
            result.ifPresent(goodsimageEntity -> shoppingCartOutDto.setImage(goodsimageEntity.getImage()));
            res.add(shoppingCartOutDto);
        }
        return res;
    }

    @Override
    public void deleteGoods(ShoppingcartEntity entity) {
        shoppingCartRepository.delete(entity);
    }

    @Override
    public void changeCount(short shoppingCartId, short goodsId, short count) {
        ShoppingcartEntityPK shoppingCartEntityPK = new ShoppingcartEntityPK();
        shoppingCartEntityPK.setShoppingCartId(shoppingCartId);
        shoppingCartEntityPK.setGoodsId(goodsId);
        Optional<ShoppingcartEntity> shoppingCartEntity = shoppingCartRepository.findById(shoppingCartEntityPK);
        if (shoppingCartEntity.isPresent()){
            ShoppingcartEntity changedShoppingCartEntity = shoppingCartEntity.get();
            changedShoppingCartEntity.setCount(count);
            shoppingCartRepository.save(changedShoppingCartEntity);
        }
    }
}
