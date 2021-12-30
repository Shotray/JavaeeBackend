package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.GoodsEntity;
import com.xagd.javaeebackend.Entity.OrderEntity;
import com.xagd.javaeebackend.Entity.PostEntity;
import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.MeEditDto;
import com.xagd.javaeebackend.OutDto.MyGoodsOutDto;
import com.xagd.javaeebackend.OutDto.OrderGoodsOutDto;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.*;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
    @Autowired
    private MeService meService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    ModelMapper modelMapper = new ModelMapper();

    @Test
    @Transactional
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
        String userName = "0303030";
        boolean flag = userService.existsUserEntityByUserName(userName);
        assertFalse(flag);
    }

    @Test
    public void checkExistPhone(){
        String phone = "123";
        boolean flag = userService.existsUserEntityByUserPhone(phone);
        assertFalse(flag);
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

    @Test
    public void checkProfile() {
        UserEntity user = this.userRepository.findUserEntityByUserId((short) 10);
        assertNotNull(user);
    }

    @Test
    public void checkSelfPosts() {
        PostEntity[] lst = this.postService.getPosts((short) 10);
        assertNotNull(lst);
    }

    @Test
    public void checkSelfGoods() {
        List<MyGoodsOutDto> lst = this.goodsService.getGoods((short) 10);
        assertNotNull(lst);
    }

    @Test
    public void checkSelfOrder() {
        List<OrderGoodsOutDto> lst = this.orderService.getOrders((short) 10);
        assertNotNull(lst);
    }

    @Test
    @Transactional
    public void checkEditProfile() {
        MeEditDto meEditDto = new MeEditDto();
        UserEntity user = this.userRepository.findUserEntityByUserId((short) 10);
        meEditDto.setUserName(user.getUserName());
        meEditDto.setUserNickname(user.getUserNickname());
        meEditDto.setUserPhone(user.getUserPhone());
        meEditDto.setUserSex(user.getUserSex());
        meEditDto.setUserNickname("testnickname");
        UserEntity editedUser = this.meService.updateInfo(meEditDto, (short) 10);
        assertEquals("testnickname", editedUser.getUserNickname());
    }
}
