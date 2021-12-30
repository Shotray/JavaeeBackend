package com.xagd.javaeebackend;

import com.xagd.javaeebackend.OutDto.OrderGoodsOutDto;
import com.xagd.javaeebackend.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO:此处写OrderTest类的描述
 *
 * @author shotray
 * @since 2021/12/30 19:47
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderTest {

    @Resource
    private OrderService orderService;

//    @Test
//    public void testGetOrders(){
//        List<OrderGoodsOutDto> orderGoodsOutDtos = orderService.getOrders((short)22);
//        for(OrderGoodsOutDto orderGoodsOutDto:orderGoodsOutDtos){
//            System.out.println(orderGoodsOutDto);
//        }
//
//    }

}

