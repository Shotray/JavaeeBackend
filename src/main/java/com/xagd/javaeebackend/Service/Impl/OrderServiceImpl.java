package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.Repository.OrderEntityRepository;
import com.xagd.javaeebackend.Service.OrderService;
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
    
}
