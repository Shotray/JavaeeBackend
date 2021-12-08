package com.xagd.javaeebackend.Controller;

import com.xagd.javaeebackend.Utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {


    @RequestMapping("/")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    @PostMapping("/oss")
    public String testOSS(MultipartFile file){
        return OSSUtil.uploadFile(file, "hh");
    }
}
