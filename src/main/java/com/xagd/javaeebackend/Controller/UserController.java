package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.UserEntity;
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

//    @Autowired
//    private UserRepository userRepository;

    @SaCheckLogin
    @PostMapping(value = "testtoken")
    public void testToken(@RequestHeader Map<String, String> headers){
        headers.forEach((key, value) -> {
            System.out.println((String.format("Header '%s' = %s", key, value)));
        });
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody HashMap<String, Object> postInfo){
        String userNameOrPhone = postInfo.getOrDefault("username", null).toString();
        String password = postInfo.getOrDefault("password", null).toString();

        UserEntity user = userService.findUserEntityByUserNameOrUserPhone(userNameOrPhone);
        if(user == null){
            return new ResponseEntity<>("There is no such user !",HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (user.getUserPassword().equals(password)){
            StpUtil.login(user.getUserId());
//            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("tokenValue", tokenInfo.tokenValue);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("Password error", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody HashMap<String, Object> postInfo){
        System.out.println("start register");

        String userName = postInfo.getOrDefault("userName", null).toString();
        String userNickName = postInfo.getOrDefault("userNickname", null).toString();
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        String password = postInfo.getOrDefault("userPassword", null).toString();
        String code = postInfo.getOrDefault("code", null).toString();

        if (!userService.checkCode(phone, code)){
            return new ResponseEntity<>("Verification code error", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setUserNickname(userNickName);
        user.setUserPhone(phone);
        user.setUserPassword(password);
        System.out.println(user.toString());
        try {
            UserEntity addedUser =  userService.addUser(user);
            HashMap<String, Object> response = new HashMap<String, Object>();
            response.put("userId", addedUser.getUserId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/getCode")
    public ResponseEntity getCode(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        System.out.println("phone: " + phone);
        if (userService.sendSMS(phone)){
            return new ResponseEntity<>("Sent successfully !", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/checkEmail")
    public ResponseEntity checkEmail(@RequestBody HashMap<String, Object> postInfo){
        String email = postInfo.getOrDefault("userEmail", null).toString();
        System.out.println("email: " + email);
        if (userService.existsUserEntityByUserEmail(email)){
            return new ResponseEntity<>(email + " has been registered.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(email + " is available.", HttpStatus.OK);
    }

    @PostMapping(value = "/checkUserName")
    public ResponseEntity checkUserName(@RequestBody HashMap<String, Object> postInfo){
        String userName = postInfo.getOrDefault("userName", null).toString();
        System.out.println("userName: " + userName);
        if (userService.existsUserEntityByUserName(userName)){
            System.out.println(userName + " is not available.");
            return new ResponseEntity<>(userName + " has been registered.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        System.out.println(userName + " is available.");
        return new ResponseEntity<>(userName + " is available.", HttpStatus.OK);
    }

    @PostMapping(value = "/checkPhone")
    public ResponseEntity checkPhone(@RequestBody HashMap<String, Object> postInfo){
        String phone = postInfo.getOrDefault("userPhone", null).toString();
        System.out.println("phone: " + phone);
        if (userService.existsUserEntityByUserPhone(phone)){
            return new ResponseEntity<>(phone + " has been registered.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(phone + " is available.", HttpStatus.OK);
    }

    @PostMapping(value = "/checkPassword")
    public ResponseEntity checkPassword(@RequestBody HashMap<String, Object> postInfo){
        String password = postInfo.getOrDefault("userPassword", null).toString();
        System.out.println("password: " + password);
        if (userService.checkPassword(password)){
            return new ResponseEntity<>(password + " is available.", HttpStatus.OK);
        }
        return new ResponseEntity<>(password + " is not available.", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
