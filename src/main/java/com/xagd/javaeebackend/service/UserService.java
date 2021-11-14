package com.xagd.javaeebackend.service;

import com.xagd.javaeebackend.model.UserEntity;
import com.xagd.javaeebackend.repository.UserRepository;
import com.xagd.javaeebackend.utils.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public UserEntity findUserEntityByUserNameOrUserPhone(String userNameOrPhone){
        return userRepository.findUserEntityByUserNameOrUserPhone(userNameOrPhone, userNameOrPhone);
    }

    public UserEntity addUser(UserEntity user){
        return userRepository.save(user);
    }

    public boolean existsUserEntityByUserPhone(String userPhone){
        return userRepository.existsUserEntityByUserPhone(userPhone);
    }

    public boolean existsUserEntityByUserEmail(String userEmail){
        return userRepository.existsUserEntityByUserEmail(userEmail);
    }

    public boolean existsUserEntityByUserName(String userName){
        return userRepository.existsUserEntityByUserName(userName);
    }

    public boolean checkPassword(String password){
        if (password.length() >= 8){
            String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
            return password.matches(regex);
        }
        return false;
    }

    public boolean sendSMS(String phone){
        String code = getCode();
        String resp = SendSMS.send(phone, code);


        if(resp.contains("提交成功")){
            redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    public boolean checkCode(String phone, String code){
        String realcode = (String) redisTemplate.opsForValue().get(phone);
        return realcode != null && realcode.equals(code);
    }

    private String getCode(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 6; i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

}
