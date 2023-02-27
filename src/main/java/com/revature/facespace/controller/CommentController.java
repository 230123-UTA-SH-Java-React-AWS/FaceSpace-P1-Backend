package com.revature.facespace.controller;

import com.revature.facespace.model.Comment;
import com.revature.facespace.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/{postId}")
    public List<Comment> getAllCommentsByPost(Integer postId) {
        return commentRepository.findAllCommentsByPostId(postId);
    }

    @PostMapping
    public List<Comment> addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return commentRepository.findAllCommentsByPostId(comment.getPostId());
    }
}
