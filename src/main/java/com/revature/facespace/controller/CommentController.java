package com.revature.facespace.controller;

import com.revature.facespace.model.Comment;
import com.revature.facespace.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/api/comments/{postId}")
    public List<Comment> getAllCommentsByPost(Integer postId) {
        return commentRepository.findAllCommentsByPostId(postId);
    }

    @PostMapping("/api/comments")
    public Comment addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }
}
