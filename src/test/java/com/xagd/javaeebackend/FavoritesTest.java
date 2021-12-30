package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.InDto.FavoritesGoodsInDto;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.FavoritesGoodsRepository;
import com.xagd.javaeebackend.Repository.FavoritesGoodsViewRepository;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Service.FavoritesGoodsViewService;
import com.xagd.javaeebackend.Service.FavoritesService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO:此处写FavoritesTest类的描述
 *
 * @author shotray
 * @since 2021/12/13 13:32
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FavoritesTest {
    @Resource
    private FavoritesRepository favoritesRepository;

    @Autowired
    private FavoritesService favoritesService;

    @Resource
    private FavoritesGoodsRepository favoritesGoodsRepository;

    @Resource
    private FavoritesGoodsViewRepository favoritesGoodsViewRepository;

    @Autowired
    private FavoritesGoodsViewService favoritesGoodsViewService;

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    @Transactional
    public void testAddFavorites(){
        FavoritesInDto favoritesInDto = new FavoritesInDto();
        favoritesInDto.setFavoritesName("test");
    }

}

