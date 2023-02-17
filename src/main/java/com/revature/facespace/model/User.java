package com.revature.facespace.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "user_profile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String emailAddress;
    private String password;
    private String givenName;
    private String surname;

    @Transient
    boolean loggedIn;

//    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Post> posts;
//    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment> comments;


}