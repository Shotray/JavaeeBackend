package com.xagd.javaeebackend.Service.Impl;

import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Repository.MessageEntityRepository;
import com.xagd.javaeebackend.Service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

        List<MessageEntity> ret = new ArrayList<MessageEntity>();
        int len = lst1.size();
        MessageEntity[] arr = (MessageEntity[]) lst1.toArray();
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (arr[i].getMessageDate().compareTo(arr[j].getMessageDate()) > 0) {
                    MessageEntity tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        lst1.clear();
        for (int i = 0; i < len; ++i) {
            ret.add(arr[i]);
        }
        return ret;
    }

    @Override
    public MessageEntity addMessage(MessageEntity message) {
        this.messageRepository.save(message);
        return message;
    }
}
