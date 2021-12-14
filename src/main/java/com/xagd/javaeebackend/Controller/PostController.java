package com.xagd.javaeebackend.Controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.Entity.PostimageEntity;
import com.xagd.javaeebackend.InDto.PostEditInDto;
import com.xagd.javaeebackend.InDto.PostsDto;
import com.xagd.javaeebackend.Service.PostService;
import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value = "/postEdit")
    public ResponseEntity postEdit(@RequestPart("formData") PostEntity postEntity, @RequestPart("files") MultipartFile[] files) {
        System.out.println("dnajskfka");
        try {
            postEntity = postService.addPost(postEntity, files);
            return new ResponseEntity<>(postEntity, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/postNumber")
    public ResponseEntity getPostNumber() {
        try {
            String num = Integer.toString(postService.getPosts().size());
            return new ResponseEntity(num, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity("get post number error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/posts")
//    public ResponseEntity getPosts(@RequestParam int maxNumber, @RequestParam int pageNumber) {
//        System.out.println("posts requests started");
//        List<PostUserEntity> postUserEntity = new ArrayList<>();
//        try {
//            postUserEntity = postService.getPosts();
//            List<PostUserEntity> pageElement = new ArrayList<>();
//            int sta = maxNumber * (pageNumber - 1);
//            for (int i = sta; i < sta + maxNumber; ++i) {
//                pageElement.add(postUserEntity.get(i));
//            }
//            return new ResponseEntity<>(pageElement, HttpStatus.OK);
//        }
//        catch (Exception e) {
//            System.out.println(e);
//            return new ResponseEntity<>("get posts error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/posts")
    public ResponseEntity getPostsByNoAndSize(@RequestParam int maxNumber, @RequestParam int pageNumber){
        try{
            return new ResponseEntity<>(postService.getPosts(pageNumber, maxNumber), HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("get posts error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
