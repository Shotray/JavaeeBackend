package com.xagd.javaeebackend;

import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Repository.MessageEntityRepository;
import com.xagd.javaeebackend.Service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatTest {

    @Resource
    private MessageEntityRepository messageEntityRepository;

    @Autowired
    private ChatService chatService;

    @Test
    public void addMessage() {
        int preMessageNum = this.messageEntityRepository.findAll().size();
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageType((byte) 0);
        messageEntity.setMessageDate(new Timestamp(System.currentTimeMillis()));
        messageEntity.setMessageFromUserId((short) 23);
        messageEntity.setMessageContent("test content");
        messageEntity.setMessageToUserId((short) 22);
        int addedMessageNum = this.messageEntityRepository.findAll().size();
        assertEquals(1, addedMessageNum - preMessageNum);
    }

    @Test
    public void getMessage() {
        List<MessageEntity> messages = this.chatService.getHistoryMessage((short) 23, (short) 22);
        assertNotNull(messages);
    }
}
