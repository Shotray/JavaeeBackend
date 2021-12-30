package com.xagd.javaeebackend.InDto;

public class MeEditDto {
    String userNickname;
    String userName;
    String userPhone;
    byte userSex;

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public String getUserNickname() {
        return userNickname;
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

}
