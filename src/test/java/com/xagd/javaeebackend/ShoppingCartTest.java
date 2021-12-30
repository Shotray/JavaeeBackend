package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntityPK;
import com.xagd.javaeebackend.OutDto.ShoppingCartOutDto;
import com.xagd.javaeebackend.Repository.GoodsRepository;
import com.xagd.javaeebackend.Repository.ShoppingCartRepository;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByShoppingCartId(){
        ArrayList<ShoppingCartOutDto> list = shoppingCartService.findAllByShoppingCartId((short) 3);
        assertNotNull(list);
    }

    @Test
    @Transactional
    public void addAndDelete(){
        List<ShoppingcartEntity> shoppingCartEntityList = shoppingCartRepository.findAllByShoppingCartId((short) 3);
        ShoppingcartEntity shoppingcartEntity = shoppingCartEntityList.get(0);
        int goodsNumOld = shoppingCartEntityList.size();
        shoppingCartService.deleteGoods(shoppingcartEntity);
        int goodsNumDeleted = shoppingCartRepository.findAllByShoppingCartId((short) 3).size();
        assertEquals(1, goodsNumOld - goodsNumDeleted);
        shoppingCartService.addGoods(shoppingcartEntity);
        int goodsNumAdded = shoppingCartRepository.findAllByShoppingCartId((short) 3).size();
        assertEquals(1, goodsNumAdded - goodsNumDeleted);
        shoppingCartService.changeCount(shoppingcartEntity.getShoppingCartId(), shoppingcartEntity.getGoodsId(), (short) 3);
        ShoppingcartEntityPK shoppingCartEntityPK = new ShoppingcartEntityPK();
        shoppingCartEntityPK.setShoppingCartId(shoppingcartEntity.getShoppingCartId());
        shoppingCartEntityPK.setGoodsId(shoppingcartEntity.getGoodsId());
        assertEquals((short) 3, shoppingCartRepository.findById(shoppingCartEntityPK).get().getCount());
    }
}
