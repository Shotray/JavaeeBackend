package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;

@RestController
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @SaCheckLogin
    @GetMapping
    public ResponseEntity findAll() {
        try {
            short userId = (short) StpUtil.getLoginIdAsInt();
            return new ResponseEntity<>(shoppingCartService.findAllByShoppingCartId(userId), HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @DeleteMapping
    public ResponseEntity delete(@RequestParam short goodsId){
        try {
            short userId = (short) StpUtil.getLoginIdAsInt();
            System.out.println(goodsId);
            ShoppingcartEntity shoppingcartEntity = new ShoppingcartEntity();
            shoppingcartEntity.setShoppingCartId(userId);
            shoppingcartEntity.setGoodsId(goodsId);
            shoppingCartService.deleteGoods(shoppingcartEntity);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
