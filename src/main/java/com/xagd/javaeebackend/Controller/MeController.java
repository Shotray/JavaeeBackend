package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.OutDto.MyGoodsOutDto;
import com.xagd.javaeebackend.OutDto.OrderGoodsOutDto;
import com.xagd.javaeebackend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping(value = "/info")
    public ResponseEntity info() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        UserEntity userEntity = userService.findUserEntityByUserId(userId);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @GetMapping(value = "/order")
    public ResponseEntity order() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        List<OrderGoodsOutDto> orders = this.orderService.getOrders(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/goods")
    public ResponseEntity goods() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        List<MyGoodsOutDto> goods = this.goodsService.getGoods(userId);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity post() {
        Short userId = (short)StpUtil.getLoginIdAsInt();
        PostEntity[] posts = this.postService.getPosts(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping(value = "/info")
    public ResponseEntity info(@RequestPart("info") MeEditDto meEditDto, @RequestPart("image") MultipartFile[] files) {
        try {
            return new ResponseEntity<>(this.meService.updateInfo(meEditDto, files), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
