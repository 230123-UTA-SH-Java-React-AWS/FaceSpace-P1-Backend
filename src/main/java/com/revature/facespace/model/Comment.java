package com.revature.facespace.model;

import jakarta.persistence.*;



@Entity
@Table(name = "post_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String writtenText;
    private Integer profileId;
    private Integer postId;
}
