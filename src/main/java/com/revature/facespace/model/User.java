package com.revature.facespace.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_profile")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique=true)
    private String emailAddress;
    private String password;
    private String givenName;
    private String surname;

    @Transient
    boolean loggedIn;

    @OneToMany(/*mappedBy = "profileId",*/ cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private List<Post> posts;
    @OneToMany(/*mappedBy = "profileId",*/ cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private List<Comment> comments;

    @OneToMany(/*mappedBy = "profileId",*/ cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private List<Likes> likes;

    @OneToMany(/*mappedBy = "profileId",*/ cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "followerId", referencedColumnName = "id")
    private List<Following> following;

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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return loggedIn == user.loggedIn && Objects.equals(id, user.id) && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(password, user.password) && Objects.equals(givenName, user.givenName) && Objects.equals(surname, user.surname) && Objects.equals(posts, user.posts) && Objects.equals(comments, user.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailAddress, password, givenName, surname, loggedIn, posts, comments);
    }


}