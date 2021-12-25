package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
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
@RequestMapping(value = "favorites")
public class FavoriteController {

    @Autowired
    FavoritesService favoritesService;

    @Autowired
    FavoritesGoodsViewService favoritesGoodsViewService;

    @SaCheckLogin
    @PostMapping("createFavorites")
    public ResponseEntity createFavorites(@RequestBody FavoritesInDto favoritesInDto) {
        FavoritesEntity favoritesEntity = new FavoritesEntity();
        favoritesEntity.setFavoritesName(favoritesInDto.getFavoritesName());
        Short userId = (short) StpUtil.getLoginIdAsInt();

        try {
            FavoritesEntity ret = favoritesService.addFavorites(favoritesEntity, userId);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @GetMapping("getFavorites")
    public ResponseEntity getFavoritesGoods() {
        try {
            Short userId = (short) StpUtil.getLoginIdAsInt();

            FavoritesGoodsOutDto favoritesGoodsOutDto = new FavoritesGoodsOutDto();

            ArrayList<FavoritesEntity> favoritesEntities = favoritesService.getFavoritesEntityByUserId(userId);
            for (FavoritesEntity item : favoritesEntities) {
                ArrayList<FavoritesGoodsViewEntity> favoritesGoodsViewEntities = favoritesGoodsViewService.getGoodsInfoByFavoritesId(item.getFavoritesId());
                ArrayList<HashMap<String, String>> goods = new ArrayList<>();
                Integer count = 0;
                for (FavoritesGoodsViewEntity good : favoritesGoodsViewEntities) {
                    HashMap<String, String> goodMap = new HashMap<>();
                    goodMap.put("goodsId", String.valueOf(good.getGoodsId()));
                    goodMap.put("name", good.getGoodsName());
                    goodMap.put("price", good.getGoodsPrice().toString());
                    if (count == 0) {
                        goodMap.put("offset", "0");
                    } else {
                        goodMap.put("offset", "1");
                    }
                    count++;
                    goods.add(goodMap);
                }
                FavoritesGoodsOutDto.GoodsOutDto goodsDto = favoritesGoodsOutDto.new GoodsOutDto();
                goodsDto.setFavoritesName(item.getFavoritesName());
                goodsDto.setGoods(goods);
                favoritesGoodsOutDto.addFavoritesGoods(goodsDto);
            }
            return new ResponseEntity<>(favoritesGoodsOutDto, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

