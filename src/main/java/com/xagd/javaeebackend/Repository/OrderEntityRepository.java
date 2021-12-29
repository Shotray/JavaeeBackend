package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.util.annotation.Nullable;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Short> {
    @Nullable
    List<OrderEntity> getOrderEntitiesByUserId(Short userId);
}