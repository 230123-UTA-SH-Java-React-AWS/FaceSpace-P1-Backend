package com.revature.facespace.controller;

import com.revature.facespace.model.Post;
import com.revature.facespace.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/api/posts/{postId}")
    public Post getPostById(@PathVariable Integer postId) {
        return postRepository.getById(postId);
    }

    @GetMapping("/api/posts/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable Integer userId) {
        return postRepository.findAllPostsByProfileId(userId);
    }

    @GetMapping("api/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/api/posts")
    public Post addPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
