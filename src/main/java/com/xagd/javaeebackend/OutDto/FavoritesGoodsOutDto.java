package com.xagd.javaeebackend.OutDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO:此处写FavoritesGoodsOutDto类的描述
 *
 * @author shotray
 * @since 2021/12/12 23:08
 */

public class FavoritesGoodsOutDto {
    public class GoodsOutDto{
        String favoritesName;
        List<HashMap<String,String>> goods = new ArrayList<>();

        public void setFavoritesName(String favoritesName){
            this.favoritesName = favoritesName;
        }

        public String getFavoritesName(){return this.favoritesName;}

        public void setGoods(List<HashMap<String,String>> goods){this.goods = goods;}

        public List<HashMap<String,String>> getGoods() {
            return this.goods;
        }

        @Override
        public String toString() {
            return "GoodsOutDto{" +
                    "favoritesName=" + favoritesName +
                    ", goods=" + goods +
                    '}';
        }
    }

    private ArrayList<GoodsOutDto> favoritesGoods = new ArrayList<>();

    public void addFavoritesGoods(GoodsOutDto favoritesGoods){this.favoritesGoods.add(favoritesGoods);}

    public ArrayList<GoodsOutDto> getFavoritesGoods(){return this.favoritesGoods;}

    @Override
    public String toString() {
        return "FavoritesGoodsOutDto{" +
                "favoritesGoods=" + favoritesGoods +
                '}';
    }
}

