package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.LoginInfoInDto;
import com.xagd.javaeebackend.InDto.RegisterInfoInDto;
import com.xagd.javaeebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/logout")
    public ResponseEntity logout(){
        System.out.println(StpUtil.isLogin());
        if (StpUtil.isLogin()){
            StpUtil.logout();
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not login");
    }

    @PostMapping(value = "/autoLogin")
    public ResponseEntity autoLogin(@RequestHeader Map<String, String> headers) {
        System.out.println(StpUtil.isLogin());
        headers.forEach((key, value) -> {
            System.out.println((String.format("Header '%s' = %s", key, value)));
        });
        if (StpUtil.isLogin()){
            Short userId = (short)StpUtil.getLoginIdAsInt();
            UserEntity user = userService.findUserEntityByUserId(userId);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not login");
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginInfoInDto loginInfoInDto, @RequestHeader Map<String, String> headers){
        System.out.println(StpUtil.isLogin());
        if (StpUtil.isLogin()){
            Short userId = (short)StpUtil.getLoginIdAsInt();
            UserEntity user = userService.findUserEntityByUserId(userId);
            return ResponseEntity.ok(user);
        }
        UserEntity user = userService.findUserEntityByUserNameOrUserPhone(loginInfoInDto.getUserName());
        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("There is no such user !");
        }
        if (user.getUserPassword().equals(loginInfoInDto.getUserPassword())){
            StpUtil.login(user.getUserId());
            System.out.println(StpUtil.getLoginIdAsInt());
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password error");
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterInfoInDto registerInfoInDto){
        System.out.println("start register");

        if (!userService.checkCode(registerInfoInDto.getUserPhone(), registerInfoInDto.getCode())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Verification code error");
        }

        UserEntity user = new UserEntity();
        user.setUserName(registerInfoInDto.getUserName());
        user.setUserNickname(registerInfoInDto.getUserNickname());
        user.setUserPhone(registerInfoInDto.getUserPhone());
        user.setUserPassword(registerInfoInDto.getUserPassword());

        try {
            UserEntity addedUser =  userService.addUser(user);
            StpUtil.login(addedUser.getUserId());
            return ResponseEntity.ok(addedUser);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/getCode")
    public ResponseEntity getCode(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        if (userService.sendSMS(phone)){
            return ResponseEntity.ok("Sent successfully !");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping(value = "/checkEmail")
    public ResponseEntity checkEmail(@RequestBody HashMap<String, Object> postInfo){
        String email = postInfo.getOrDefault("userEmail", null).toString();
        if (userService.existsUserEntityByUserEmail(email)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(email + " has been registered.");
        }
        return ResponseEntity.ok(email + " is available.");
    }

    @PostMapping(value = "/checkUserName")
    public ResponseEntity checkUserName(@RequestBody HashMap<String, Object> postInfo){
        String userName = postInfo.getOrDefault("userName", null).toString();
        System.out.println("userName: " + userName);
        if (userService.existsUserEntityByUserName(userName)){
            System.out.println(userName + " is not available.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userName + " has been registered.");
        }
        return ResponseEntity.ok(userName + " is available.");
    }

    @PostMapping(value = "/checkPhone")
    public ResponseEntity checkPhone(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        if (userService.existsUserEntityByUserPhone(phone)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(phone + " has been registered.");
        }
        return ResponseEntity.ok(phone + " is available.");
    }
}
