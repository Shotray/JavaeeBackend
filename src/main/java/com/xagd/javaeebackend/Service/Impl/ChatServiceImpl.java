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
        List<MessageEntity> lst1 = this.messageRepository.getMessageEntitiesByMessageFromUserIdAndMessageToUserId(fromUserId, toUserId);
        List<MessageEntity> lst2 = this.messageRepository.getMessageEntitiesByMessageFromUserIdAndMessageToUserId(toUserId, fromUserId);
        for (MessageEntity msg: lst2) {
            lst1.add(msg);
        }
        return lst1;
    }

    @Override
    public MessageEntity addMessage(MessageEntity message) {
        this.messageRepository.save(message);
        return message;
    }
}
