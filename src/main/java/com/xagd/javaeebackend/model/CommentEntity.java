package com.xagd.javaeebackend.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment", schema = "db", catalog = "")
public class CommentEntity {
    private short commentId;
    private Short userId;
    private Short commentParentId;
    private Short replyId;
    private String commentContent;
    private Timestamp commentDate;
    private Byte commentStatus;

    @Id
    @Column(name = "comment_id")
    public short getCommentId() {
        return commentId;
    }

    public void setCommentId(short commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "user_id")
    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "comment_parent_id")
    public Short getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Short commentParentId) {
        this.commentParentId = commentParentId;
    }

    @Basic
    @Column(name = "reply_id")
    public Short getReplyId() {
        return replyId;
    }

    public void setReplyId(Short replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "comment_content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "comment_date")
    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    @Basic
    @Column(name = "comment_status")
    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (commentParentId != null ? !commentParentId.equals(that.commentParentId) : that.commentParentId != null)
            return false;
        if (replyId != null ? !replyId.equals(that.replyId) : that.replyId != null) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;
        if (commentStatus != null ? !commentStatus.equals(that.commentStatus) : that.commentStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) commentId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (commentParentId != null ? commentParentId.hashCode() : 0);
        result = 31 * result + (replyId != null ? replyId.hashCode() : 0);
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (commentStatus != null ? commentStatus.hashCode() : 0);
        return result;
    }
}
