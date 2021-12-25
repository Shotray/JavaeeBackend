package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.UserService;
import com.xagd.javaeebackend.Utils.SendSMS;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserEntity findUserEntityByUserNameOrUserPhone(String userNameOrPhone){
        return userRepository.findUserEntityByUserNameOrUserPhone(userNameOrPhone, userNameOrPhone);
    }

    @Override
    public UserEntity findUserEntityByUserId(Short userId){
        return userRepository.findUserEntityByUserId(userId);
    }

    @Override
    public UserEntity addUser(UserEntity user){
        return userRepository.save(user);
    }

    @Override
    public boolean existsUserEntityByUserPhone(String userPhone){
        return userRepository.existsUserEntityByUserPhone(userPhone);
    }

    @Override
    public boolean existsUserEntityByUserEmail(String userEmail){
        return userRepository.existsUserEntityByUserEmail(userEmail);
    }

    public boolean existsUserEntityByUserName(String userName){
        return userRepository.existsUserEntityByUserName(userName);
    }

    @Override
    public boolean sendSMS(String phone){
        String code = getCode();
        String resp = SendSMS.send(phone, code);
        try{
            Document doc = DocumentHelper.parseText(resp);
            Element root = doc.getRootElement();
            String respCode = root.element("code").getText();
            if (respCode.equals("2")){
                redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
                return true;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkCode(String phone, String code){
        String realcode = (String) redisTemplate.opsForValue().get(phone);
        return realcode != null && realcode.equals(code);
    }

    @Override
    public String getCode(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            result.append(random.nextInt(10));
        }
        return result.toString();
    }
}
