package com.xagd.javaeebackend.Service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.*;
import com.xagd.javaeebackend.InDto.FavoritesGoodsInDto;
import com.xagd.javaeebackend.InDto.FavoritesInDto;
import com.xagd.javaeebackend.OutDto.FavoritesGoodsOutDto;
import com.xagd.javaeebackend.Repository.*;
import com.xagd.javaeebackend.Service.FavoritesService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * TODO:此处写FavoritesServiceImpl类的描述
 *
 * @author shotray
 * @since 2021/12/12 19:29
 */

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Resource
    private GoodsRepository goodsRepository;

    @Resource
    private GoodsImageRepository goodsImageRepository;

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
    public FavoritesGoodsOutDto getFavoritesGoods() {
        Short userId = (short) StpUtil.getLoginIdAsInt();

        FavoritesGoodsOutDto favoritesGoodsOutDto = new FavoritesGoodsOutDto();

        List<FavoritesEntity> favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        for (FavoritesEntity item : favoritesEntities) {
            List<FavoritesGoodsViewEntity> favoritesGoodsViewEntities = favoritesGoodsViewRepository.findFavoritesGoodsViewEntityByFavoritesId(item.getFavoritesId());
            List<HashMap<String, String>> goods = new ArrayList<>();
            int count = 0;
            for (FavoritesGoodsViewEntity good : favoritesGoodsViewEntities) {
                List<GoodsImageEntity> goodsImageEntity = goodsImageRepository.getGoodsimageEntitiesByGoodsId(good.getGoodsId());
                HashMap<String, String> goodMap = new HashMap<>();
                goodMap.put("goodsId", String.valueOf(good.getGoodsId()));
                goodMap.put("name", good.getGoodsName());
                goodMap.put("price", good.getGoodsPrice().toString());
                goodMap.put("picture",goodsImageEntity.get(0).getImage());
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
            goodsDto.setFavoritesId(item.getFavoritesId());
            goodsDto.setGoods(goods);
            favoritesGoodsOutDto.addFavoritesGoods(goodsDto);
        }
        return favoritesGoodsOutDto;
    }

    @Override
    @Transactional
    @Modifying
    public void deleteFavorites(short favoriteId) {
        List<FavoritesGoodsEntity> favoritesGoodsEntities = favoritesGoodsRepository.getFavoritesGoodsEntitiesByFavoritesId(favoriteId);
        for(FavoritesGoodsEntity favoritesGoodsEntity:favoritesGoodsEntities){
            GoodsEntity goodsEntity = goodsRepository.getGoodsEntityByGoodsId(favoritesGoodsEntity.getGoodsId());
            goodsEntity.setGoodsFavorite((short) (goodsEntity.getGoodsFavorite()-1));
            goodsRepository.save(goodsEntity);
        }
        favoritesGoodsRepository.deleteFavoritesGoodsEntitiesByFavoritesId(favoriteId);
        favoritesRepository.deleteFavoritesEntityByFavoritesId(favoriteId);
    }

    @Override
    public List<HashMap<String, String>> getFavorites() {
        Short userId = (short) StpUtil.getLoginIdAsInt();
        List<FavoritesEntity> favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        List<HashMap<String,String>> favorites = new ArrayList<>();
        for(FavoritesEntity favoritesEntity : favoritesEntities){
            HashMap<String,String> favorite = new HashMap<>();
            String favoriteName = favoritesEntity.getFavoritesName();
            String favoriteId = String.valueOf(favoritesEntity.getFavoritesId());
            favorite.put("favoriteId",favoriteId);
            favorite.put("favoriteName",favoriteName);
            favorites.add(favorite);
        }
        return favorites;
    }

    @Override
    public FavoritesGoodsEntity addFavoritesGoods(FavoritesGoodsInDto favoritesGoodsInDto) {
        FavoritesGoodsEntity favoritesGoods = new FavoritesGoodsEntity();
        favoritesGoods.setFavoritesId(favoritesGoodsInDto.getFavoriteId());
        favoritesGoods.setGoodsId(favoritesGoodsInDto.getGoodsId());
        FavoritesGoodsEntity favoritesGoodsEntity = favoritesGoodsRepository.save(favoritesGoods);
        GoodsEntity goodsEntity = goodsRepository.getGoodsEntityByGoodsId(favoritesGoodsInDto.getGoodsId());
        goodsEntity.setGoodsFavorite((short) (goodsEntity.getGoodsFavorite()+1));
        goodsRepository.save(goodsEntity);
        return favoritesGoodsEntity;
    }

    @Override
    @Transactional
    @Modifying
    public void deleteFavoritesGoods(Short goodsId) {
        Short userId = (short) StpUtil.getLoginIdAsInt();
        List<FavoritesEntity> favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        Set<Short> favoritesSet = new HashSet<>();
        for(FavoritesEntity favoritesEntity:favoritesEntities){
            favoritesSet.add(favoritesEntity.getFavoritesId());
        }
        List<FavoritesGoodsEntity> favoritesGoodsEntities = favoritesGoodsRepository.getFavoritesGoodsEntitiesByGoodsId(goodsId);
        for(FavoritesGoodsEntity favoritesGoodsEntity:favoritesGoodsEntities){
            if(favoritesSet.contains(favoritesGoodsEntity.getFavoritesId())){
                favoritesGoodsRepository.deleteFavoritesGoodsEntityByFavoritesIdAndGoodsId(
                        favoritesGoodsEntity.getFavoritesId(),
                        goodsId
                );
                GoodsEntity goodsEntity = goodsRepository.getGoodsEntityByGoodsId(goodsId);
                goodsEntity.setGoodsFavorite((short) (goodsEntity.getGoodsFavorite()-1));
                goodsRepository.save(goodsEntity);
            }
        }
    }

    @Override
    public Boolean checkFavoritesGoods(Short goodsId) {
        Short userId = (short) StpUtil.getLoginIdAsInt();
        List<FavoritesEntity> favoritesEntities = favoritesRepository.getFavoritesEntityByUserId(userId);
        Set<Short> favoritesSet = new HashSet<>();
        for(FavoritesEntity favoritesEntity:favoritesEntities){
            favoritesSet.add(favoritesEntity.getFavoritesId());
        }
        List<FavoritesGoodsEntity> favoritesGoodsEntities = favoritesGoodsRepository.getFavoritesGoodsEntitiesByGoodsId(goodsId);
        for(FavoritesGoodsEntity favoritesGoodsEntity:favoritesGoodsEntities){
            if(favoritesSet.contains(favoritesGoodsEntity.getFavoritesId())){
                return true;
            }
        }
        return false;
    }


}

