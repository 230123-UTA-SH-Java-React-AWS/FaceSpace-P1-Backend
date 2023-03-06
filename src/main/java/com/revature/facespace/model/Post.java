package com.revature.facespace.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.io.Serializable;

@Entity
@Table (name = "user_post")
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String writtenText;
    private Integer profileId;

    @OneToMany(/*mappedBy = "postId",*/ cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private List<Likes> likes;

    public Post() {};
    public Post(Integer id, String writtenText, Integer profileId) {
        this.id = id;
        this.writtenText = writtenText;
        this.profileId = profileId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(writtenText,
                post.writtenText) && Objects.equals(profileId,
                post.profileId) && Objects.equals(comments, post.comments) && Objects.equals(likes, post.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, writtenText, profileId, comments, likes);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", writtenText='" + writtenText + '\'' +
                ", profileId=" + profileId +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
