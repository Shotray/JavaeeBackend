package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Short> {
    OrderEntity[] getOrderEntitiesByUserId(Short userId);
}