package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.LoginInfoInDto;
import com.xagd.javaeebackend.InDto.RegisterInfoInDto;
import com.xagd.javaeebackend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @SaCheckLogin
    @PostMapping(value = "testtoken")
    public void testToken(@RequestHeader Map<String, String> headers){
        headers.forEach((key, value) -> {
            System.out.println((String.format("Header '%s' = %s", key, value)));
        });
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginInfoInDto loginInfoInDto, @RequestHeader Map<String, String> headers){
        System.out.println(StpUtil.isLogin());
        if (StpUtil.isLogin()){
            Short userId = (short)StpUtil.getLoginIdAsInt();
            UserEntity user = loginService.findUserEntityByUserId(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        UserEntity user = loginService.findUserEntityByUserNameOrUserPhone(loginInfoInDto.getUserName());
        if(user == null){
            return new ResponseEntity<>("There is no such user !",HttpStatus.UNAUTHORIZED);
        }
        if (user.getUserPassword().equals(loginInfoInDto.getUserPassword())){
            StpUtil.login(user.getUserId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Password error", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterInfoInDto registerInfoInDto){
        System.out.println("start register");

        if (!loginService.checkCode(registerInfoInDto.getUserPhone(), registerInfoInDto.getCode())){
            return new ResponseEntity<>("Verification code error", HttpStatus.UNAUTHORIZED);
        }

        UserEntity user = new UserEntity();
        user.setUserName(registerInfoInDto.getUserName());
        user.setUserNickname(registerInfoInDto.getUserNickname());
        user.setUserPhone(registerInfoInDto.getUserPhone());
        user.setUserPassword(registerInfoInDto.getUserPassword());
        System.out.println(user.toString());
        try {
            UserEntity addedUser =  loginService.addUser(user);
            StpUtil.login(addedUser.getUserId());
            return new ResponseEntity<>(addedUser, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/getCode")
    public ResponseEntity getCode(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        System.out.println("phone: " + phone);
        if (loginService.sendSMS(phone)){
            return new ResponseEntity<>("Sent successfully !", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/checkEmail")
    public ResponseEntity checkEmail(@RequestBody HashMap<String, Object> postInfo){
        String email = postInfo.getOrDefault("userEmail", null).toString();
        System.out.println("email: " + email);
        if (loginService.existsUserEntityByUserEmail(email)){
            return new ResponseEntity<>(email + " has been registered.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(email + " is available.", HttpStatus.OK);
    }

    @PostMapping(value = "/checkUserName")
    public ResponseEntity checkUserName(@RequestBody HashMap<String, Object> postInfo){
        String userName = postInfo.getOrDefault("userName", null).toString();
        System.out.println("userName: " + userName);
        if (loginService.existsUserEntityByUserName(userName)){
            System.out.println(userName + " is not available.");
            return new ResponseEntity<>(userName + " has been registered.", HttpStatus.UNAUTHORIZED);
        }
        System.out.println(userName + " is available.");
        return new ResponseEntity<>(userName + " is available.", HttpStatus.OK);
    }

    @PostMapping(value = "/checkPhone")
    public ResponseEntity checkPhone(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        System.out.println("phone: " + phone);
        if (loginService.existsUserEntityByUserPhone(phone)){
            return new ResponseEntity<>(phone + " has been registered.", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(phone + " is available.", HttpStatus.OK);
    }

}