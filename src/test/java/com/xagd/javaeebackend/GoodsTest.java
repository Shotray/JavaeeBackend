package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * TODO:此处写GoodsTest类的描述
 *
 * @author shotray
 * @since 2021/12/25 14:43
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoodsTest {
    @Autowired
    GoodsService goodsService;

//    @Test
//    public void goodsDetailedTest(){
//        GoodsDetailedDto goodsDetailedDto = goodsService.getGoodsDetailed((short)1);
//        System.out.println(goodsDetailedDto);
//    }
}

