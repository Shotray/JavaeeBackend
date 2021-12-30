package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.FavoritesEntity;
import com.xagd.javaeebackend.Entity.FavoritesGoodsViewEntity;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.FavoritesGoodsRepository;
import com.xagd.javaeebackend.Repository.FavoritesGoodsViewRepository;
import com.xagd.javaeebackend.Repository.FavoritesRepository;
import com.xagd.javaeebackend.Service.FavoritesService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO:此处写FavoritesServiceImpl类的描述
 *
 * @author shotray
 * @since 2021/12/12 19:29
 */

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Resource
    private FavoritesRepository favoritesRepository;

    @Resource
    private FavoritesGoodsRepository favoritesGoodsRepository;

    @Resource
    private FavoritesGoodsViewRepository favoritesGoodsViewRepository;

    @Override
    public FavoritesEntity addFavorites(FavoritesInDto favoritesInDto) {
        Short userId = (short) StpUtil.getLoginIdAsInt();

        FavoritesEntity favoritesEntity = new FavoritesEntity();
        favoritesEntity.setFavoritesName(favoritesInDto.getFavoritesName());
        favoritesEntity.setUserId(userId);
        FavoritesEntity addedFavorites = favoritesRepository.save(favoritesEntity);
        return addedFavorites;
    }

    @Override
    public ArrayList<FavoritesEntity> getFavoritesEntityByUserId(short userId) {
        ArrayList<FavoritesEntity> favoritesEntities = new ArrayList<>();
        favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        return favoritesEntities;
    }

    @Override
    public FavoritesGoodsOutDto getFavoritesGoods() {
        Short userId = (short) StpUtil.getLoginIdAsInt();

        FavoritesGoodsOutDto favoritesGoodsOutDto = new FavoritesGoodsOutDto();

        List<FavoritesEntity> favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        for (FavoritesEntity item : favoritesEntities) {
            List<FavoritesGoodsViewEntity> favoritesGoodsViewEntities = favoritesGoodsViewRepository.findFavoritesGoodsViewEntityByFavoritesId(item.getFavoritesId());
            List<HashMap<String, String>> goods = new ArrayList<>();
            int count = 0;
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
        return favoritesGoodsOutDto;
    }

    @Override
    @Transactional
    @Modifying
    public void deleteFavorites(short favoriteId) {
        favoritesGoodsRepository.deleteFavoritesGoodsEntitiesByFavoritesId(favoriteId);
        favoritesRepository.deleteFavoritesEntityByFavoritesId(favoriteId);
    }
}

