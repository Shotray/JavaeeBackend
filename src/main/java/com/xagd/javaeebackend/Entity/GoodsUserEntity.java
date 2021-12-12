package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "goods_user", schema = "db", catalog = "")
public class GoodsUserEntity {
    private short userId;
    private short goodsId;
    private byte goodsCategory;
    private String goodsName;
    private BigDecimal goodsPrice;
    private Timestamp goodsDate;
    private short sellNum;
    private byte sellStatus;
    private String goodsIntroduction;
    private short goodsFavorite;
    private String goodsUnit;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private byte userSex;
    private String userImage;
    private Timestamp userCreateTime;
    private String userNickname;
    private Byte receiveId;

    @Basic
    @Column(name = "user_id")
    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    @Basic
    @Id
    @Column(name = "goods_id")
    public short getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(short goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_category")
    public byte getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(byte goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_price")
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "goods_date")
    public Timestamp getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Timestamp goodsDate) {
        this.goodsDate = goodsDate;
    }

    @Basic
    @Column(name = "sell_num")
    public short getSellNum() {
        return sellNum;
    }

    public void setSellNum(short sellNum) {
        this.sellNum = sellNum;
    }

    @Basic
    @Column(name = "sell_status")
    public byte getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(byte sellStatus) {
        this.sellStatus = sellStatus;
    }

    @Basic
    @Column(name = "goods_introduction")
    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    @Basic
    @Column(name = "goods_favorite")
    public short getGoodsFavorite() {
        return goodsFavorite;
    }

    public void setGoodsFavorite(short goodsFavorite) {
        this.goodsFavorite = goodsFavorite;
    }

    @Basic
    @Column(name = "goods_unit")
    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_sex")
    public byte getUserSex() {
        return userSex;
    }

    public void setUserSex(byte userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_image")
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Basic
    @Column(name = "user_create_time")
    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Basic
    @Column(name = "user_nickname")
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "receive_id")
    public Byte getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Byte receiveId) {
        this.receiveId = receiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsUserEntity that = (GoodsUserEntity) o;

        if (userId != that.userId) return false;
        if (goodsId != that.goodsId) return false;
        if (goodsCategory != that.goodsCategory) return false;
        if (sellNum != that.sellNum) return false;
        if (sellStatus != that.sellStatus) return false;
        if (goodsFavorite != that.goodsFavorite) return false;
        if (userSex != that.userSex) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(that.goodsPrice) : that.goodsPrice != null) return false;
        if (goodsDate != null ? !goodsDate.equals(that.goodsDate) : that.goodsDate != null) return false;
        if (goodsIntroduction != null ? !goodsIntroduction.equals(that.goodsIntroduction) : that.goodsIntroduction != null)
            return false;
        if (goodsUnit != null ? !goodsUnit.equals(that.goodsUnit) : that.goodsUnit != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPhone != null ? !userPhone.equals(that.userPhone) : that.userPhone != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userImage != null ? !userImage.equals(that.userImage) : that.userImage != null) return false;
        if (userCreateTime != null ? !userCreateTime.equals(that.userCreateTime) : that.userCreateTime != null)
            return false;
        if (userNickname != null ? !userNickname.equals(that.userNickname) : that.userNickname != null) return false;
        if (receiveId != null ? !receiveId.equals(that.receiveId) : that.receiveId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) userId;
        result = 31 * result + (int) goodsId;
        result = 31 * result + (int) goodsCategory;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (goodsDate != null ? goodsDate.hashCode() : 0);
        result = 31 * result + (int) sellNum;
        result = 31 * result + (int) sellStatus;
        result = 31 * result + (goodsIntroduction != null ? goodsIntroduction.hashCode() : 0);
        result = 31 * result + (int) goodsFavorite;
        result = 31 * result + (goodsUnit != null ? goodsUnit.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (int) userSex;
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        result = 31 * result + (userCreateTime != null ? userCreateTime.hashCode() : 0);
        result = 31 * result + (userNickname != null ? userNickname.hashCode() : 0);
        result = 31 * result + (receiveId != null ? receiveId.hashCode() : 0);
        return result;
    }
}
