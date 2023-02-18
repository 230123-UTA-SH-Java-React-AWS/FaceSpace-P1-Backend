package com.revature.facespace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "post_like")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer profileId;
    private Integer postId;

    public Likes() {};

    public Likes(Integer id, Integer profileId, Integer postId) {
        this.id = id;
        this.profileId = profileId;
        this.postId = postId;
    }

    public Likes(Integer profileId, Integer postId) {
        this.profileId = profileId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
