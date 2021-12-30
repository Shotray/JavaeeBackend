package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.InDto.GoodsShoppingCartInDto;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import com.xagd.javaeebackend.OutDto.GoodsDetailedDto;
import com.xagd.javaeebackend.OutDto.GoodsSearchOutDto;
import com.xagd.javaeebackend.OutDto.MyGoodsOutDto;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Service.GoodsService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * TODO:此处写GoodsTest类的描述
 *
 * @author shotray
 * @since 2021/12/25 14:43
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsTest {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    @Transactional
    public void addGoods(){
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsCategory((byte) 2);
        goodsEntity.setGoodsName("testGoodsName");
        goodsEntity.setGoodsPrice(new BigDecimal("9.9"));
        goodsEntity.setSellNum((short) 22);
        goodsEntity.setGoodsIntroduction("testtest");
        goodsEntity.setGoodsUnit("件");
        MultipartFile[] multipartFiles = new MultipartFile[0];
        int goodsNum = goodsRepository.findAll().size();
        GoodsEntity addedGoodsEntity = goodsService .addGoods(goodsEntity, multipartFiles, (short) 3);
        int goodsNumAdded = goodsRepository.findAll().size();
        assertEquals(1, goodsNumAdded - goodsNum);

        goodsService.deleteGood(addedGoodsEntity.getGoodsId());
        int goodsNumDeled = goodsRepository.findAll().size();
        assertEquals(1, goodsNumAdded - goodsNumDeled);
    }

    @Test
    public void getGoodsByCategory(){
        ArrayList<GoodsCategoryOutDto> arrayList = goodsService.getGoodsByCategory((byte) 2);
        assertNotNull(arrayList);
    }

    @Test
    public void getGoodsByUserId(){
        List<MyGoodsOutDto> list = goodsService.getGoods((short) 3);
        assertNotNull(list);
    }

    @Test
    public void getGoodsByName(){
        ArrayList<GoodsSearchOutDto> arrayList = goodsService.getGoodsByName("test");
        assertNotNull(arrayList);
    }

    @Test
    public void getGoodsByOwnerName(){
        ArrayList<GoodsSearchOutDto> arrayList = goodsService.getGoodsByOwnerName("test");
        assertNotNull(arrayList);
    }


    @Test
    @Transactional
    public void goodsDetailedTest(){
        GoodsDetailedDto goodsDetailedDto = goodsService.getGoodsDetailed((short)1);
        System.out.println(goodsDetailedDto);
    }
}

