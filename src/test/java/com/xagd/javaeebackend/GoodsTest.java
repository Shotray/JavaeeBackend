package com.xagd.javaeebackend;

import com.xagd.javaeebackend.OutDto.GoodsDetailedDto;
import com.xagd.javaeebackend.Service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * TODO:此处写GoodsTest类的描述
 *
 * @author shotray
 * @since 2021/12/25 14:43
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
    @Autowired
    GoodsService goodsService;

    @Test
    @Transactional
    public void goodsDetailedTest(){
        GoodsDetailedDto goodsDetailedDto = goodsService.getGoodsDetailed((short)1);
        System.out.println(goodsDetailedDto);
    }
}

