package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.OrderInDto;
import com.xagd.javaeebackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderContoller {

    @Autowired
    private OrderService orderService;

    @SaCheckLogin
    @PostMapping()
    public ResponseEntity addOrder(@RequestBody OrderInDto orderInDto){
        try {
            short userId = (short) StpUtil.getLoginIdAsInt();
            orderService.addOrder(orderInDto, userId);
            return ResponseEntity.ok("ok");
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @SaCheckLogin
    @GetMapping("{orderId}")
    public ResponseEntity getOrderDetail(@PathVariable short orderId){
        try{
            return ResponseEntity.ok(orderService.getOrderDetail(orderId));
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
