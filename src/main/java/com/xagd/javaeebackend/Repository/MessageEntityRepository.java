package com.xagd.javaeebackend.Repository;

import com.xagd.javaeebackend.Entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface MessageEntityRepository extends JpaRepository<MessageEntity, Timestamp> {
    List<MessageEntity> getMessageEntitiesByMessageFromUserIdOrMessageToUserId(Short fromUserId, Short toUserId);
    List<MessageEntity> getMessageEntitiesByMessageFromUserIdAndMessageToUserId(Short fromUserId, Short toUserId);
}