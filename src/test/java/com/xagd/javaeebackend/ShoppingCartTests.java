package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.GoodsShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ShoppingCartTests {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    public void findALl(){
        ArrayList<ShoppingCartOutDto> list = shoppingCartService.findAllByShoppingCartId((short) 22);
        System.out.println(list);
    }
}
