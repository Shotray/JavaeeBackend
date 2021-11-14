package com.xagd.javaeebackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "postcomment", schema = "db", catalog = "")
@IdClass(PostcommentEntityPK.class)
public class PostcommentEntity {
    private short postId;
    private short commentId;

    @Id
    @Column(name = "post_id")
    public short getPostId() {
        return postId;
    }

    public void setPostId(short postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "comment_id")
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

        PostcommentEntity that = (PostcommentEntity) o;

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
