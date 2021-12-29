package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            return ResponseEntity.ok(shoppingCartService.findAllByShoppingCartId(userId));
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @SaCheckLogin
    @PutMapping("changeCount")
    public ResponseEntity changeCount(@RequestParam short goodsId, @RequestParam short count){
        try {
            short userId = (short) StpUtil.getLoginIdAsInt();
            shoppingCartService.changeCount(userId, goodsId, count);
            return ResponseEntity.ok("ok");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
            return ResponseEntity.ok("ok");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
