package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.InDto.GoodsShoppingCartInDto;
import com.xagd.javaeebackend.OutDto.GoodsCategoryOutDto;
import com.xagd.javaeebackend.OutDto.MyGoodsOutDto;
import com.xagd.javaeebackend.Entity.ShoppingcartEntity;
import com.xagd.javaeebackend.OutDto.GoodsDetailedDto;
import com.xagd.javaeebackend.OutDto.GoodsSearchOutDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface GoodsService {
    GoodsEntity addGoods(GoodsEntity goods, MultipartFile[] files, Short userId);

    ArrayList<GoodsCategoryOutDto> getGoodsByCategory(byte category);

    List<MyGoodsOutDto> getGoods(Short userId);
    ArrayList<GoodsSearchOutDto> getGoodsByName(String name);

    ArrayList<GoodsSearchOutDto> getGoodsByOwnerName(String ownerName);

    void deleteGood(Short id);

    GoodsDetailedDto getGoodsDetailed(Short goodsId);

    ShoppingcartEntity addGoodsToShoppingCart(GoodsShoppingCartInDto goodsShoppingCartInDto);

}
