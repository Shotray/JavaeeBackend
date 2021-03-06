package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.GoodsImageEntity;
import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;
import com.xagd.javaeebackend.OutDto.OrderGoodsOutDto;
import com.xagd.javaeebackend.Repository.GoodsImageRepository;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Repository.OrderEntityRepository;
import com.xagd.javaeebackend.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderEntityRepository orderEntityRepository;

    @Resource
    private GoodsRepository goodsRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;


    @Override
    public List<OrderGoodsOutDto> getOrders(Short userId) {
        List<OrderGoodsOutDto> orderGoodsOutDtos = new ArrayList<>();
        List<OrderEntity> orderEntities = orderEntityRepository.getOrderEntitiesByUserId(userId);
        for(OrderEntity orderEntity :orderEntities){
            ModelMapper modelMapper = new ModelMapper();
            OrderGoodsOutDto orderGoodsOutDto = modelMapper.map(orderEntity, OrderGoodsOutDto.class);
            GoodsImageEntity goodsImage = new GoodsImageEntity();
            goodsImage.setGoodsId(orderEntity.getGoodsId());
            Example<GoodsImageEntity> example = Example.of(goodsImage);
            Optional<GoodsImageEntity> image = goodsImageRepository.findOne(example);
            orderGoodsOutDto.setGoodsImage(image.get().getImage());
            GoodsEntity goodsEntity = goodsRepository.getById(orderEntity.getGoodsId());
            orderGoodsOutDto.setGoodsPrice(goodsEntity.getGoodsPrice());
            orderGoodsOutDto.setGoodsName(goodsEntity.getGoodsName());
            orderGoodsOutDtos.add(orderGoodsOutDto);
        }
        return orderGoodsOutDtos;
    }

    @Override
    public OrderEntity addOrder(OrderInDto orderInDto, short userId) {
        ModelMapper modelMapper = new ModelMapper();
        OrderEntity orderEntity = modelMapper.map(orderInDto, OrderEntity.class);
        orderEntity.setUserId(userId);
        orderEntity.setStatus((short) 0);
        System.out.println("-------------------------");
        System.out.println(orderEntity.toString());
        return orderEntityRepository.save(orderEntity);
    }

    @Override
    public OrderGoodsOutDto getOrderDetail(short orderId) {
        ModelMapper modelMapper = new ModelMapper();
        OrderEntity orderEntity = orderEntityRepository.getById(orderId);
        OrderGoodsOutDto orderGoodsOutDto = modelMapper.map(orderEntity, OrderGoodsOutDto.class);
        GoodsEntity goodsEntity = goodsRepository.getById(orderEntity.getGoodsId());
//        orderGoodsOutDto = modelMapper.map(goodsEntity, OrderGoodsOutDto.class);
        orderGoodsOutDto.setGoodsName(goodsEntity.getGoodsName());
        orderGoodsOutDto.setGoodsPrice(goodsEntity.getGoodsPrice());
        return orderGoodsOutDto;
    }

    @Override
    public OrderEntity putOrderDetail(short orderId) {
        OrderEntity orderEntity = orderEntityRepository.getById(orderId);
        orderEntity.setStatus((short) 1);
        return orderEntityRepository.save(orderEntity);
    }
}
