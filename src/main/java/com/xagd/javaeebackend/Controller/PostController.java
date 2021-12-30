package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.CommentEntity;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @SaCheckLogin
    @PostMapping(value = "/postEdit")
    public ResponseEntity postEdit(@RequestPart("formData") PostEntity postEntity, @RequestPart("files") MultipartFile[] files) {
        try {
            postEntity = postService.addPost(postEntity, files, (short) StpUtil.getLoginIdAsInt());
            return new ResponseEntity<>(postEntity, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/postNumber")
    public ResponseEntity getPostNumber() {
        try {
            return new ResponseEntity(postService.getPosts().size(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity("get post number error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deletePost(@RequestParam Short id) {
        try {
            this.postService.deletePost(id);
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

    @GetMapping(value = "/{postId}")
    public ResponseEntity getPostDetail(@PathVariable(value = "postId") Short postId) {
        try  {
            return new ResponseEntity<>(postService.getPostDetailById(postId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SaCheckLogin
    @PostMapping(value = "/comment")
    public ResponseEntity addPostComment(@RequestBody HashMap<String, String> info){
        try{
            System.out.println(info.toString());
            short userId = (short) StpUtil.getLoginIdAsInt();
            String content = info.get("content");
            short postId = Short.parseShort(info.get("id"));
            CommentEntity commentEntity = postService.addComment(postId, userId, content);
            return ResponseEntity.ok(commentEntity);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/comment/{postId}")
    public ResponseEntity getPostComment(@PathVariable(value = "postId") Short postId){
        try  {
            return ResponseEntity.ok(postService.getPostComment(postId));
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
