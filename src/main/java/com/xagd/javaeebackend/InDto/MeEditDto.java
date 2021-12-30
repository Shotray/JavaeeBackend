package com.xagd.javaeebackend.InDto;

public class MeEditDto {
    String userNickName;
    String userRealName;
    String userPhone;
    byte userGender;

    public String getUserNickName() {
        return userNickName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public byte getUserGender() {
        return userGender;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserGender(byte userGender) {
        this.userGender = userGender;
    }
}
