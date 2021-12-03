package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.InDto.LoginInfoInDto;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Utils.SendSMS;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();
    private Object UserEntity;

    @Test
    public void getUserList(){
        List<UserEntity> userEntities = userRepository.findAll();
        System.out.println(userEntities.toString());
    }

    @Test
    public void checkExistPhone(){
        String str = "123";
        boolean flag = userRepository.existsUserEntityByUserPhone(str);
        System.out.println(flag);
    }

    @Test
    public void checkSMS(){
        SendSMS.send("17692419697", "1234");
    }

    @Test
    public void checkDto(){
        LoginInfoInDto loginInfoInDto = modelMapper.map(UserEntity, LoginInfoInDto.class);
    }

}
