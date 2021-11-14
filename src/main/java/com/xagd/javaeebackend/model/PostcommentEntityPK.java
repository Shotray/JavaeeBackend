package com.xagd.javaeebackend.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PostcommentEntityPK implements Serializable {
    private short postId;
    private short commentId;

    @Column(name = "post_id")
    @Id
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Column(name = "comment_id")
    @Id
    public short getCommentId() {
        return commentId;
    }

    public void setCommentId(short commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostcommentEntityPK that = (PostcommentEntityPK) o;

        if (postId != that.postId) return false;
        if (commentId != that.commentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) postId;
        result = 31 * result + (int) commentId;
        return result;
    }
}
