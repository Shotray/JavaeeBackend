package com.xagd.javaeebackend.Controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @SaCheckLogin
    @GetMapping(value = "/{userid}")
    public ResponseEntity getHistoryMessage(@PathVariable(value = "userid") Short userId) {
        try {
            return new ResponseEntity<>(this.chatService.getHistoryMessage(userId, (short) StpUtil.getLoginIdAsInt()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping(value = "/add")
//    public ResponseEntity addChatMessage(@RequestBody MessageEntity message) {
//        try {
//            return new ResponseEntity<>(this.chatService.addMessage(message), HttpStatus.OK);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
