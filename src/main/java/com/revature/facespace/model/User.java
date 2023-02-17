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

    public User() {

    }

    public User(Integer id, String emailAddress, String password,
                String givenName, String surname) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.givenName = givenName;
        this.surname = surname;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}