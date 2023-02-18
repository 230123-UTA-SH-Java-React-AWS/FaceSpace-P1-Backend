package com.revature.facespace.controller;

import com.revature.facespace.model.Post;
import com.revature.facespace.repository.PostRepository;
import com.revature.facespace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/posts/{postId}")
    public Post getPostById(@PathVariable Integer postId) {
        return postRepository.getById(postId);
    }

    @GetMapping("/api/posts/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable Integer userId) {
        return postRepository.findAllPostsByProfileId(userId);
    }

    @PostMapping("/api/posts")
    public Post addPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
}
