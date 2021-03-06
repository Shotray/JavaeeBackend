package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;
import com.xagd.javaeebackend.OutDto.OrderGoodsOutDto;
import com.xagd.javaeebackend.Repository.OrderEntityRepository;
import com.xagd.javaeebackend.Service.OrderService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO:此处写OrderTest类的描述
 *
 * @author shotray
 * @since 2021/12/30 19:47
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderTest {

    @Resource
    private OrderEntityRepository orderEntityRepository;

    @Resource
    private OrderService orderService;

    @Test
    public void testGetOrders(){
        List<OrderGoodsOutDto> orderGoodsOutDtos = orderService.getOrders((short)1000);
        assertEquals(orderGoodsOutDtos.size(), 0);
    }

    @Test
    @Transactional
    public void testAddOrder(){
        OrderInDto orderInDto = new OrderInDto();
        orderInDto.setGoodsId((short) 1);
        orderInDto.setCount((short)3);
        orderInDto.setLocation("同济大学四平路校区");
        orderInDto.setTotalPrice(BigDecimal.valueOf(22.7));

        long before = orderEntityRepository.getOrderEntitiesByUserId((short)1).size();
        orderService.addOrder(orderInDto,(short)1);
        long after = orderEntityRepository.getOrderEntitiesByUserId((short)1).size();
        assertEquals(before+1,after);
    }

    @Test
    @Transactional
    public void testPutOrder(){
        orderService.putOrderDetail((short)1);
        OrderEntity orderEntity = orderEntityRepository.getById((short)1);
        assertEquals(orderEntity.getStatus(),(short)1);
    }



}

