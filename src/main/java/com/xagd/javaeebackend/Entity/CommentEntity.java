package com.xagd.javaeebackend.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO:此处写CommentEntity类的描述
 *
 * @author shotray
 * @since 2021/12/30 20:27
 */

@Entity
@Table(name = "comment", schema = "db", catalog = "")
public class CommentEntity {
    private short commentId;
    private short postId;
    private Short userId;
    private String commentContent;
    private Timestamp commentDate;

    @Id
    @Column(name = "comment_id")
    public short getCommentId() {
        return commentId;
    }

    public void setCommentId(short commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "post_id")
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (postId != that.postId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (commentContent != null ? !commentContent.equals(that.commentContent) : that.commentContent != null)
            return false;
        if (commentDate != null ? !commentDate.equals(that.commentDate) : that.commentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) commentId;
        result = 31 * result + (int) postId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        return result;
    }
}

