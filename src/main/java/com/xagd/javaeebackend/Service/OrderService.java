package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.OrderEntity;

import java.util.List;

public interface OrderService {
    public OrderEntity[] getOrders(Short userId);
}