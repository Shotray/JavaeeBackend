package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsUserEntity;
import com.xagd.javaeebackend.Entity.GoodsimageEntity;
import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;
import com.xagd.javaeebackend.OutDto.GoodsSearchOutDto;
import com.xagd.javaeebackend.Repository.OrderEntityRepository;
import com.xagd.javaeebackend.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderEntityRepository orderEntityRepository;

    @Override
    public List<OrderEntity> getOrders(Short userId) {
        return this.orderEntityRepository.getOrderEntitiesByUserId(userId);
    }

    @Override
    public OrderEntity addOrder(OrderInDto orderInDto, short userId) {
        ModelMapper modelMapper = new ModelMapper();
        OrderEntity orderEntity = modelMapper.map(orderInDto, OrderEntity.class);
        return orderEntityRepository.save(orderEntity);
    }
}
