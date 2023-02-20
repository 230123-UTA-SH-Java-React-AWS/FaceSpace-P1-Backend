package com.revature.facespace.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "post_comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String writtenText;
    private Integer profileId;
    private Integer postId;

    public Comment () {};

    public Comment (Integer id, String writtenText, Integer profileId,
                    Integer postId) {
        this.id = id;
        this.writtenText = writtenText;
        this.profileId = profileId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWrittenText() {
        return writtenText;
    }

    public void setWrittenText(String writtenText) {
        this.writtenText = writtenText;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(writtenText,
                comment.writtenText) && Objects.equals(profileId,
                comment.profileId) && Objects.equals(postId, comment.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, writtenText, profileId, postId);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", writtenText='" + writtenText + '\'' +
                ", profileId=" + profileId +
                ", postId=" + postId +
                '}';
    }
}
