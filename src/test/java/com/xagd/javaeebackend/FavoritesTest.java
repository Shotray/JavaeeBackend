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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testFavoritesGoodsView(){
        int size = favoritesGoodsRepository.getFavoritesGoodsEntitiesByFavoritesId((short) 1).size();
        int serveSize = favoritesGoodsViewService.getGoodsInfoByFavoritesId((short) 1).size();
        assertEquals(size,serveSize);
    }


    @Test
    @Transactional
    public void testAddFavoritesGoods(){
        FavoritesGoodsInDto favoritesGoodsInDto = new FavoritesGoodsInDto();
        favoritesGoodsInDto.setFavoriteId((short)1);
        favoritesGoodsInDto.setGoodsId((short) 3);

        long before = favoritesGoodsRepository.getFavoritesGoodsEntitiesByFavoritesId((short)1).size();
        favoritesService.addFavoritesGoods(favoritesGoodsInDto);
        long after = favoritesGoodsRepository.getFavoritesGoodsEntitiesByFavoritesId((short)1).size();
        assertEquals(before+1,after);
    }


}

