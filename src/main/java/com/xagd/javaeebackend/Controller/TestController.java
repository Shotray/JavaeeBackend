package com.xagd.javaeebackend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
