package com.xagd.javaeebackend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message", schema = "db", catalog = "")
@IdClass(MessageEntityPK.class)
public class MessageEntity {
    private Timestamp messageDate;
    private short messageFromUserId;
    private short messageToUserId;
    private byte messageType;
    private String messageContent;

    @Id
    @Column(name = "message_date")
    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    @Id
    @Column(name = "message_from_user_id")
    public short getMessageFromUserId() {
        return messageFromUserId;
    }

    public void setMessageFromUserId(short messageFromUserId) {
        this.messageFromUserId = messageFromUserId;
    }

    @Id
    @Column(name = "message_to_user_id")
    public short getMessageToUserId() {
        return messageToUserId;
    }

    public void setMessageToUserId(short messageToUserId) {
        this.messageToUserId = messageToUserId;
    }

    @Basic
    @Column(name = "message_type")
    public byte getMessageType() {
        return messageType;
    }

    public void setMessageType(byte messageType) {
        this.messageType = messageType;
    }

    @Basic
    @Column(name = "message_content")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (messageFromUserId != that.messageFromUserId) return false;
        if (messageToUserId != that.messageToUserId) return false;
        if (messageType != that.messageType) return false;
        if (messageDate != null ? !messageDate.equals(that.messageDate) : that.messageDate != null) return false;
        if (messageContent != null ? !messageContent.equals(that.messageContent) : that.messageContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageDate != null ? messageDate.hashCode() : 0;
        result = 31 * result + (int) messageFromUserId;
        result = 31 * result + (int) messageToUserId;
        result = 31 * result + (int) messageType;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        return result;
    }
}
