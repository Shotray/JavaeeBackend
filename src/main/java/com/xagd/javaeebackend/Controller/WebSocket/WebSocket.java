package com.xagd.javaeebackend.Controller.WebSocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xagd.javaeebackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
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
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        webSocket = this;
        webSocket.userRepository = this.userRepository;
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
        for (WebSocket item: webSocketSet) {
            try {
                if (item.userId.equals(msg.getShort("userId"))) {
                    item.sendMessage(message);
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

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
