package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Repository.MessageEntityRepository;
import com.xagd.javaeebackend.Service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private MessageEntityRepository messageRepository;

    @Override
    public List<MessageEntity> getHistoryMessage(Short fromUserId, Short toUserId) {
        return this.messageRepository.getMessageEntitiesByMessageFromUserIdOrMessageToUserId(fromUserId, toUserId);
    }

    @Override
    public MessageEntity addMessage(MessageEntity message) {
        this.messageRepository.save(message);
        return message;
    }
}
