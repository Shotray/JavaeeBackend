package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class PostTests {

    @Resource
    private PostRepository postRepository;

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
}
