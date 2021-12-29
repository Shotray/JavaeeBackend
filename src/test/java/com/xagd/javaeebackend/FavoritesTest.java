package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.FavoritesGoodsViewRepository;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import com.xagd.javaeebackend.Service.FavoritesGoodsViewService;
import com.xagd.javaeebackend.Service.FavoritesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO:此处写FavoritesTest类的描述
 *
 * @author shotray
 * @since 2021/12/13 13:32
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoritesTest {
    @Resource
    private FavoritesRepository favoritesRepository;

    @Autowired
    private FavoritesService favoritesService;

    @Resource
    private FavoritesGoodsViewRepository favoritesGoodsViewRepository;

    @Autowired
    private FavoritesGoodsViewService favoritesGoodsViewService;

    @Test
    public void testView(){
        ArrayList<FavoritesGoodsViewEntity> arr = favoritesGoodsViewRepository.findFavoritesGoodsViewEntityByFavoritesId((short)3);
        for(FavoritesGoodsViewEntity item: arr){
            System.out.println(item.getGoodsName());
            System.out.println(item.getGoodsPrice());
            System.out.println(item.getSellNum());
        }
    }

    @Test
    public void getFavoritesEntity(){
        List<FavoritesEntity> favoritesEntities = favoritesService.getFavoritesEntityByUserId((short)20);
        for(FavoritesEntity item :favoritesEntities){
            System.out.println("----------");
            System.out.println(item.getFavoritesId());
            System.out.println(item.getFavoritesName());
            System.out.println(item.getUserId());
        }

        System.out.println(favoritesEntities);
    }

    @Test
    public void testDto(){
        FavoritesGoodsOutDto favoritesGoodsOutDto = new FavoritesGoodsOutDto();

        List<FavoritesEntity> favoritesEntities = favoritesService.getFavoritesEntityByUserId((short)20);
        System.out.println(favoritesEntities.size());
        for(FavoritesEntity item : favoritesEntities){
            System.out.println(item);
            System.out.println("--------------");
            ArrayList<FavoritesGoodsViewEntity> favoritesGoodsViewEntities = favoritesGoodsViewService.getGoodsInfoByFavoritesId(item.getFavoritesId());
            ArrayList<HashMap<String,String>> arr = new ArrayList<>();
            Integer count = 0;
            for(FavoritesGoodsViewEntity good:favoritesGoodsViewEntities){
                System.out.println(good);
                System.out.println("-----------");
                HashMap<String,String> goodMap = new HashMap<>();
                goodMap.put("goodsId", String.valueOf(good.getGoodsId()));
                goodMap.put("name",good.getGoodsName());
                goodMap.put("price",good.getGoodsPrice().toString());
                if(count == 0){
                    goodMap.put("offset","0");
                }
                else{
                    goodMap.put("offset","1");
                }
                count++;
                arr.add(goodMap);
            }
            FavoritesGoodsOutDto.GoodsOutDto goodsDto = favoritesGoodsOutDto.new GoodsOutDto();
            goodsDto.setFavoritesName(item.getFavoritesName());
            goodsDto.setGoods(arr);
            System.out.println(goodsDto);
            System.out.println("-----------");
            favoritesGoodsOutDto.addFavoritesGoods(goodsDto);
            System.out.println(favoritesGoodsOutDto);
            System.out.println("-----------");
        }
    }

    @Test
    public void testDeleteFavorites(){
        List<FavoritesEntity> favoritesEntities = favoritesService.getFavoritesEntityByUserId((short)20);
        System.out.println(favoritesEntities);
        favoritesService.deleteFavorites((short)3);
        List<FavoritesEntity> favoritesEntityList = favoritesService.getFavoritesEntityByUserId((short)20);
        System.out.println(favoritesEntityList);
    }
}

