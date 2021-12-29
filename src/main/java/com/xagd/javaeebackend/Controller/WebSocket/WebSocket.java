package com.xagd.javaeebackend.Controller.WebSocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Repository.UserRepository;
import com.xagd.javaeebackend.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
@ServerEndpoint(value = "/websocket/{userid}")
@Component
public class WebSocket {
    private static WebSocket webSocket;
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
    private Session session;
    private Short userId;

    @Autowired
    private ChatService chatService;

    @PostConstruct
    public void init() {
        webSocket = this;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userid") Short userId) {
        addOnlineCount();
        this.session = session;
        webSocketSet.add(this);
        this.userId = userId;
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject msg = JSON.parseObject(message);
        System.out.println(msg);
        for (WebSocket item: webSocketSet) {
            try {
                System.out.println("in try");
                if (item.userId.equals((short) Integer.parseInt(msg.getString("userID")))) {
                    System.out.println(message);

                    MessageEntity messageEntity = new MessageEntity();
                    messageEntity.setMessageDate(new Timestamp(System.currentTimeMillis()));
                    messageEntity.setMessageContent(msg.getString("message"));
                    messageEntity.setMessageType((byte) 1);
                    messageEntity.setMessageToUserId((short) Integer.parseInt(msg.getString("userID")));
                    messageEntity.setMessageFromUserId((short) Integer.parseInt(msg.getString("meID")));
                    chatService.addMessage(messageEntity);

                    item.sendMessage(messageEntity);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessage(MessageEntity message) throws IOException {
        JSONObject msg = new JSONObject();
        msg.put("messageDate", message.getMessageDate());
        msg.put("messageContent", message.getMessageContent());
        msg.put("messageType", message.getMessageType());
        msg.put("messageFromUserId", message.getMessageFromUserId());
        msg.put("messageToUserId", message.getMessageToUserId());
        this.session.getBasicRemote().sendText(msg.toString());
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
