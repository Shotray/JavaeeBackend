package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsuserEntity;
import com.xagd.javaeebackend.Repository.GoodsUserRepository;
import com.xagd.javaeebackend.Service.GoodsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsUserServiceImpl implements GoodsUserService {

    @Resource
    private GoodsUserRepository goodsUserRepository;

    @Override
    public GoodsuserEntity addGoodsUser(GoodsuserEntity goodsUserEntity) {
        return goodsUserRepository.save(goodsUserEntity);
    }
}
