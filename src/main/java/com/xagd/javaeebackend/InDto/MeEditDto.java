package com.xagd.javaeebackend.InDto;

public class MeEditDto {
    String userImageUrl;
    String userRealName;
    String userNickName;
    String userGrade;
    String userMajor;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public String getUserMajor() {
        return userMajor;
    }
}
