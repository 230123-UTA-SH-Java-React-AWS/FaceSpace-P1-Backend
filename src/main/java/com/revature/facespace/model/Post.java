package com.revature.facespace.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table (name = "user_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String writtenText;
    private Integer profileId;

//    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment> comments;

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
}
