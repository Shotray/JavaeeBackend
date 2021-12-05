package com.xagd.javaeebackend.Controller;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.InDto.PostEditInDto;
import com.xagd.javaeebackend.InDto.PostsDto;
import com.xagd.javaeebackend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity getPosts(@RequestBody PostsDto postsDto) {
        System.out.println("posts requests started");
        List<PostUserEntity> postUserEntity = new ArrayList<>();
        try {
            postUserEntity = postService.getPosts();
            List<PostUserEntity> pageElement = new ArrayList<>();
            int sta = postsDto.getMaxNumber() * (postsDto.getPageNumber() - 1);
            for (int i = sta; i < sta + postsDto.getMaxNumber(); ++i) {
                pageElement.add(postUserEntity.get(i));
            }
            return new ResponseEntity<>(pageElement, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("get posts error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}