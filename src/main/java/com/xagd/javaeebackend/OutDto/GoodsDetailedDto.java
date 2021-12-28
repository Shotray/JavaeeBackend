package com.xagd.javaeebackend.OutDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO:此处写GoodsDetailedDto类的描述
 *
 * @author shotray
 * @since 2021/12/24 23:03
 */

public class GoodsDetailedDto {
    String userName;
    String userImage;
    String goodsName;
    BigDecimal price;
    Short likes;
    String description;
    Byte category;
    List<String> goodsImage;

    public void setUserName(String userName){this.userName = userName;}
    public void setUserImage(String userImage){this.userImage = userImage;}
    public void setGoodsName(String goodsName){this.goodsName = goodsName;}
    public void setPrice(BigDecimal price){this.price = price;}
    public void setLikes(Short likes){this.likes = likes;}
    public void setDescription(String description){this.description = description;}
    public void setCategory(Byte category){this.category = category;}
    public void setGoodsImage(List<String> goodsImage){this.goodsImage = goodsImage;}
    public String getUserName(){return this.userName;}
    public String getUserImage(){return this.userImage;}
    public String getGoodsName(){return this.goodsName;}
    public BigDecimal getPrice(){return this.price;}
    public Short getLikes(){return this.likes;}
    public String getDescription(){return this.description;}
    public Byte getCategory(){return this.category;}
    public List<String> getGoodsImage(){return this.goodsImage;}

}

