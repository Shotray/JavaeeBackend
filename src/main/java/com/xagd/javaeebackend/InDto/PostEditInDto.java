package com.xagd.javaeebackend.InDto;

import org.springframework.web.multipart.MultipartFile;

public class PostEditInDto {
    public String getSenderId() {
        return senderId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }

//    public MultipartFile[] getPhotos() {
//        return photos;
//    }

    String senderId;
    String title;
    String content;
    String price;
//    MultipartFile[] photos;
}
