package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/commodity")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @SaCheckLogin
    @PostMapping(value = "publish")
    public ResponseEntity addGoods(@RequestPart("formData") GoodsEntity goodsEntity, @RequestPart("files") MultipartFile[] files) {
        try {
            Short userId = (short) StpUtil.getLoginIdAsInt();
            goodsService.addGoods(goodsEntity, files , userId);
            return ResponseEntity.ok("hh");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "classification/{category}")
    public ResponseEntity getClassification(@PathVariable(value = "category") int category){
        try{
            return ResponseEntity.ok(goodsService.getGoodsByCategory((byte) category));
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @SaCheckLogin
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

    @GetMapping("{type}")
    public ResponseEntity searchGoodsByName(@PathVariable String type, @RequestParam String keyword){
        try{
            if (type.equals("keyword")) {
                return ResponseEntity.ok(goodsService.getGoodsByName(keyword));
            }
            else if (type.equals("ownerName")){
                return ResponseEntity.ok(goodsService.getGoodsByOwnerName(keyword));
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/detailed")
    public ResponseEntity getGoodDetailedInfo(
            @RequestParam(value = "commodityId")Short goodsId
    ){
        return new ResponseEntity<>(goodsService.getGoodsDetailed(goodsId),HttpStatus.OK);
    }
}
