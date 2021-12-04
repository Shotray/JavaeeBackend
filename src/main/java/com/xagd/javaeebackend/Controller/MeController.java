package com.xagd.javaeebackend.Controller;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.InDto.MeInfoDto;
import com.xagd.javaeebackend.Service.MeService;
import com.xagd.javaeebackend.Service.UserService;
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

    @PostMapping(value = "/info")
    public ResponseEntity info(@RequestBody MeInfoDto meDto, @RequestHeader Map<String, String> headers) {
        UserEntity userEntity = userService.findUserEntityByUserId(Short.valueOf(meDto.getUserId()));
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @PostMapping(value = "/edit")
    public ResponseEntity edit(@RequestBody MeEditDto meEditDto, @RequestHeader Map<String, String> headers) {
        UserEntity userEntity = meService.updateUserEntity(
                meEditDto.getUserId(),
                meEditDto.getUserRealName(),
                meEditDto.getUserNickName(),
                meEditDto.getUserImageUrl(),
                meEditDto.getUserGrade(),
                meEditDto.getUserMajor());

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
