package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Utils.SendSMS;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public interface UserService {

    UserEntity findUserEntityByUserNameOrUserPhone(String userNameOrPhone);

    UserEntity findUserEntityByUserId(Short userId);

    UserEntity addUser(UserEntity user);

    boolean existsUserEntityByUserPhone(String userPhone);

    boolean existsUserEntityByUserEmail(String userEmail);

    boolean existsUserEntityByUserName(String userName);

    boolean sendSMS(String phone);

    boolean checkCode(String phone, String code);

    String getCode();
}
