package com.revature.facespace.controller;

import com.revature.facespace.model.Post;
import com.revature.facespace.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/{postId}")
    public Optional<Post> getPostById(@PathVariable Integer postId) {
        return postRepository.findById(postId);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable Integer userId) {
        return postRepository.findAllPostsByProfileId(userId);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
