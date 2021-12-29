package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.UserEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Utils.SendSMS;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

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

//    @Test
//    public void checkSMS(){
//        String resp = SendSMS.send("17692419697", "1234");
//        try{
//            Document doc = DocumentHelper.parseText(resp);
//            Element root = doc.getRootElement();
//            String respCode = root.element("code").getText();
//            if (respCode.equals("2")){
//                System.out.println("true");
//            }
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//    }

}
