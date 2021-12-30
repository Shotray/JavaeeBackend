package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.UserService;
import com.xagd.javaeebackend.Utils.SendSMS;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    ModelMapper modelMapper = new ModelMapper();

    @Test
    @Rollback(value = true)
    public void addAndDeleteUser(){
        int userNumOld = userRepository.findAll().size();
        UserEntity user = new UserEntity();
        user.setUserName("testUser");
        user.setUserNickname("testTestUser");
        user.setUserPassword("12345678a");
        user.setUserPhone("17692419696");
        UserEntity addedUser =  userService.addUser(user);
        int userNumNew = userRepository.findAll().size();
        assertEquals(1, userNumNew - userNumOld);
        userRepository.delete(addedUser);
        int userDeletedNum = userRepository.findAll().size();
        assertEquals(1, userNumNew - userDeletedNum);
    }

    @Test
    public void findALLUser(){
        List<UserEntity> userEntities = userRepository.findAll();
        System.out.println(userEntities.toString());
    }

    @Test
    public void checkExistUserName(){
        String userName = "111a1";
        boolean flag = userService.existsUserEntityByUserName(userName);
        assertTrue(flag);
        userName = "0303030";
        flag = userService.existsUserEntityByUserName(userName);
        assertFalse(flag);
    }

    @Test
    public void checkExistPhone(){
        String phone = "123";
        boolean flag = userService.existsUserEntityByUserPhone(phone);
        assertFalse(flag);
        phone = "17692419697";
        flag = userService.existsUserEntityByUserPhone(phone);
        assertTrue(flag);
    }

    @Test
    public void checkCode(){
        String phone = "17692419697";
        String code = userService.getCode();
        redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
        boolean flag = userService.checkCode(phone, code);
        assertTrue(flag);
    }

    @Test
    public void checkSMS(){
        String resp = SendSMS.send("17692419697", "1234");
        try{
            Document doc = DocumentHelper.parseText(resp);
            Element root = doc.getRootElement();
            String respCode = root.element("code").getText();
            if (respCode.equals("2")){
                System.out.println("true");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
