package com.xagd.javaeebackend.InDto;

public class MeEditDto {
    String userNickName;
    String userName;
    String userPhone;
    byte userSex;

    public String getUserNickName() {
        return userNickName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public byte getUserSex() {
        return userSex;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserSex(byte userSex) {
        this.userSex = userSex;
    }

}
