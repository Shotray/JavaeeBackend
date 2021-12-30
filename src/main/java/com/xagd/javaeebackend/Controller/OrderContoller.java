package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;
import com.xagd.javaeebackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderContoller {

    @Autowired
    private OrderService orderService;

    @SaCheckLogin
    @PostMapping()
    public ResponseEntity addOrder(@RequestBody OrderInDto orderInDto){
        if (StpUtil.isLogin()){
            short userId = (short)StpUtil.getLoginIdAsInt();
            orderService.addOrder(orderInDto, userId);
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not login");
    }

}
