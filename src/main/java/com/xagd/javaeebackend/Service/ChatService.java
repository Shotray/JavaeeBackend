package com.xagd.javaeebackend.Service;

import com.xagd.javaeebackend.Entity.MessageEntity;
import com.xagd.javaeebackend.Entity.UserEntity;

import java.util.List;

public interface ChatService {
    List<MessageEntity> getHistoryMessage(Short fromUserId, Short toUserId);

    MessageEntity addMessage(MessageEntity message);

    List<UserEntity> getChattedPeople(Short userId);
}
