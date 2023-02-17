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
}
