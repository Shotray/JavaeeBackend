package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.InDto.FavoritesGoodsInDto;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Service.FavoritesGoodsViewService;
import com.xagd.javaeebackend.Service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * TODO:此处写FavoriteController类的描述
 *
 * @author shotray
 * @since 2021-12-03 14:57
 */

@RestController
@RequestMapping(value = "/favorites")
public class FavoriteController {

    @Autowired
    FavoritesService favoritesService;

    @Autowired
    FavoritesGoodsViewService favoritesGoodsViewService;

    @SaCheckLogin
    @PostMapping("/createFavorites")
    public ResponseEntity createFavorites(@RequestBody FavoritesInDto favoritesInDto) {
        try {
            FavoritesEntity ret = favoritesService.addFavorites(favoritesInDto);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @GetMapping("/getFavorites")
    public ResponseEntity getFavorites(){
        try {
            return new ResponseEntity<>(favoritesService.getFavorites(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @GetMapping("/getFavorites/goods")
    public ResponseEntity getFavoritesGoods() {
        try {
            FavoritesGoodsOutDto favoritesGoodsOutDto = favoritesService.getFavoritesGoods();
            return new ResponseEntity<>(favoritesGoodsOutDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @SaCheckLogin
    @DeleteMapping("/deleteFavorites/{favoritesId}")
    public ResponseEntity deleteFavorites(
            @PathVariable(value = "favoritesId")short favoritesId
    ) {
        try {
            favoritesService.deleteFavorites(favoritesId);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @PostMapping("/add/goods")
    public ResponseEntity addGoodsToFavorites(
            @RequestBody FavoritesGoodsInDto favoritesGoodsInDto
            ){
        try {
            return new ResponseEntity<>(favoritesService.addFavoritesGoods(favoritesGoodsInDto), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @DeleteMapping("/delete/goods")
    public ResponseEntity deleteGoodsOfFavorites(
            @RequestParam(value = "goodsId")Short goodsId
    ){
        try {
            favoritesService.deleteFavoritesGoods(goodsId);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @GetMapping("/check/goods")
    public ResponseEntity checkGoodsOfFavorites(
        @RequestParam(value = "goodsId") Short goodsId
    ){
        try {
            return new ResponseEntity<>(favoritesService.checkFavoritesGoods(goodsId), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

