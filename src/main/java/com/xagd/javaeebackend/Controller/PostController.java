package com.xagd.javaeebackend.Controller;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.InDto.PostEditInDto;
import com.xagd.javaeebackend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping(value = "/postEdit")
    public ResponseEntity postEdit(@RequestBody PostEditInDto postEditInDto) {
        System.out.println("postEdit started");
        PostEntity post = new PostEntity();
        post.setPostPrice(Short.parseShort(postEditInDto.getPostPrice()));
        post.setUserId(Short.parseShort(postEditInDto.getUserId()));
        post.setPostIntroduction(postEditInDto.getPostIntroduction());

        System.out.println(post.toString());
        System.out.println("----------------设置完成");

        try {
            System.out.println("------------存入数据库");
            PostEntity addedPost = postService.addPost(post);
            return new ResponseEntity<>(addedPost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
