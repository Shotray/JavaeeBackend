package com.xagd.javaeebackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class MessageEntityPK implements Serializable {
    private Timestamp messageDate;
    private short messageFromUserId;
    private short messageToUserId;

    @Column(name = "message_date")
    @Id
    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    @Column(name = "message_from_user_id")
    @Id
    public short getMessageFromUserId() {
        return messageFromUserId;
    }

    public void setMessageFromUserId(short messageFromUserId) {
        this.messageFromUserId = messageFromUserId;
    }

    @Column(name = "message_to_user_id")
    @Id
    public short getMessageToUserId() {
        return messageToUserId;
    }

    public void setMessageToUserId(short messageToUserId) {
        this.messageToUserId = messageToUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntityPK that = (MessageEntityPK) o;

        if (messageFromUserId != that.messageFromUserId) return false;
        if (messageToUserId != that.messageToUserId) return false;
        if (messageDate != null ? !messageDate.equals(that.messageDate) : that.messageDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageDate != null ? messageDate.hashCode() : 0;
        result = 31 * result + (int) messageFromUserId;
        result = 31 * result + (int) messageToUserId;
        return result;
    }
}
