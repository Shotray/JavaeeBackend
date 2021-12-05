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

import javax.annotation.Resource;
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
