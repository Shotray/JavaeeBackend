package com.xagd.javaeebackend.InDto;

public class PostEditInDto {
    String postId;
    String userId;
    String postName;
    String postIntroduction;
    String postPrice;

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setPostIntroduction(String postIntroduction) {
        this.postIntroduction = postIntroduction;
    }

    public void setPostPrice(String postPrice) {
        this.postPrice = postPrice;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostIntroduction() {
        return postIntroduction;
    }

    public String getPostPrice() {
        return postPrice;
    }
}
