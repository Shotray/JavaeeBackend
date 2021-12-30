package com.xagd.javaeebackend;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisSpringbootApplicationTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads() {
        //相当于redis中的string类型
        redisTemplate.opsForValue().set("k1","v1");
        assertEquals("v1", redisTemplate.opsForValue().get("k1"));
    }
}