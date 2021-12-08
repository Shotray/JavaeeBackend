package com.xagd.javaeebackend.InDto;

public class PostsDto {
    int maxNumber;
    int pageNumber;

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
