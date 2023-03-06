package com.revature.facespace.model;

import java.io.Serializable;


import jakarta.persistence.*;


@Entity
@Table(name="following_list")
public class Following implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer followerId;
    private Integer followingId;
    public Following() {};
    public Following(Integer id, Integer followerId, Integer followingId) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getFollower() {
        return followerId;
    }
    public void setFollower(Integer f) {
        this.followerId = f;
    }
    public Integer getFollowing() {
        return followingId;
    }
    public void setFollowing(Integer f) {
        this.followingId = f;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((followerId == null) ? 0 : followerId.hashCode());
        result = prime * result + ((followingId == null) ? 0 : followingId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Following other = (Following) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (followerId == null) {
            if (other.followerId != null)
                return false;
        } else if (!followerId.equals(other.followerId))
            return false;
        if (followingId == null) {
            if (other.followingId != null)
                return false;
        } else if (!followingId.equals(other.followingId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Following [id=" + id + ", followerId=" + followerId + ", followingId=" + followingId + "]";
    }
    
}
