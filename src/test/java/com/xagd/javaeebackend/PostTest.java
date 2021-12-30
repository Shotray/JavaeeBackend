package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.PostUserEntity;
import com.xagd.javaeebackend.OutDto.PostDetailOutDto;
import com.xagd.javaeebackend.Repository.PostRepository;
import com.xagd.javaeebackend.Service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostTest {

    @Resource
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Test
    public void getPost(){
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "postDate"));
        Page<PostEntity> page = postRepository.findAll(pageable);
//        while(page.hasNext()){
//            for (PostEntity p: page.getContent()){
//                System.out.println(p.toString());
//            }
//        }
        System.out.println(page.isFirst());
        System.out.println(page.getTotalPages());
        System.out.println(page.getTotalElements());
    }

    @Test
    public void getPostDetail() {
        PostDetailOutDto post = this.postService.getPostDetailById((short) 1);
        assertNotNull(post);
    }

    @Test
    public void getAllPosts() {
        List<PostUserEntity> posts = this.postService.getPosts();
        assertNotNull(posts);
    }

    @Test
    public void getPostByUserId() {
        PostEntity[] posts = this.postService.getPosts((short) 23);
        assertNotNull(posts);
    }

//    @Test
//    @Transactional
//    public void addAndDeletePost() {
//        PostEntity post = new PostEntity();
//        post.setPostDate(new Timestamp(System.currentTimeMillis()));
//        post.setPostId((short) 1001);
//        post.setPostPrice((short) 100);
//        post.setPostTitle("test title");
//        post.setPostIntroduction("test intro");
//        post.setUserId((short) 3);
//        MultipartFile[] multipartFiles = new MultipartFile[0];
//        int prePostNum = this.postRepository.findAll().size();
//        PostEntity addedPost = this.postService.addPost(post, multipartFiles);
//        int addedPostNum = this.postRepository.findAll().size();
//        assertEquals(1, addedPostNum - prePostNum);
//        this.postService.deletePost(addedPost.getPostId());
//        int deletedPostNum = this.postRepository.findAll().size();
//        assertEquals(1, addedPostNum - deletedPostNum);
//    }
}
