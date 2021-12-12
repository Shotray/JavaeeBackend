package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Repository.GoodsShoppingCartRepository;
import com.xagd.javaeebackend.Repository.ShoppinCartRepository;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Resource
    private ShoppinCartRepository shoppinCartRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;

    @Resource
    private GoodsShoppingCartRepository goodsShoppingCartRepository;

    @Override
    public ShoppingcartEntity addGoods(ShoppingcartEntity shoppingCart) {
        return shoppinCartRepository.save(shoppingCart);
    }

    @Override
    public ArrayList<ShoppingCartOutDto> findAllByShoppingCartId(short shoppingCartId) {
        ArrayList<ShoppingCartOutDto> res = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        ArrayList<GoodsShoppingcartEntity> goodsShoppingCartArrayList =  goodsShoppingCartRepository.findAllByShoppingCartId(shoppingCartId);
        for(GoodsShoppingcartEntity goodsShoppingCart: goodsShoppingCartArrayList){
            GoodsimageEntity goodsImage = new GoodsimageEntity();
            goodsImage.setGoodsId(goodsShoppingCart.getGoodsId());
            Example<GoodsimageEntity> example = Example.of(goodsImage);
            Optional<GoodsimageEntity> result = goodsImageRepository.findOne(example);
            ShoppingCartOutDto shoppingCartOutDto = modelMapper.map(goodsShoppingCart, ShoppingCartOutDto.class);
            shoppingCartOutDto.setImage(result.get().getImage());
            res.add(shoppingCartOutDto);
        }
        return res;
    }

    @Override
    public void deleteGoods(ShoppingcartEntity entity) {
        shoppinCartRepository.delete(entity);
    }
}
