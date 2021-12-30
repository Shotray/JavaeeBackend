package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getOrders(Short userId);

    OrderEntity addOrder(OrderInDto orderInDto, short userId);
}
