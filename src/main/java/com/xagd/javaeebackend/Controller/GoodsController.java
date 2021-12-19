package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Service.GoodsService;
import com.xagd.javaeebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @SaCheckLogin
    @PostMapping(value = "publish")
    public ResponseEntity addGoods(@RequestPart("formData") GoodsEntity goodsEntity, @RequestPart("files") MultipartFile[] files) {
        try {
            Short userId = (short) StpUtil.getLoginIdAsInt();
            goodsService.addGoods(goodsEntity, files , userId);
            return new ResponseEntity<>("hh", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "classification/{category}")
    public ResponseEntity getClassification(@PathVariable(value = "category") int category){
        try{
            return new ResponseEntity<>(goodsService.getGoodsByCategory((byte) category), HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteGood(@RequestParam Short id) {
        try {
            this.goodsService.deleteGood(id);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
