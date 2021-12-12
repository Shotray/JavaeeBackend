package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.InDto.MeInfoDto;
import com.xagd.javaeebackend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/me")
public class MeController {
    private MeService meService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PostService postService;

    //    @SaCheckLogin
    @GetMapping(value = "/info")
    public ResponseEntity info() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        UserEntity userEntity = userService.findUserEntityByUserId(userId);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/order")
    public ResponseEntity order() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        OrderEntity[] orders = this.orderService.getOrders(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/goods")
    public ResponseEntity goods() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        GoodsEntity[] goods = this.goodsService.getGoods(userId);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity post() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        PostEntity[] posts = this.postService.getPosts(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
