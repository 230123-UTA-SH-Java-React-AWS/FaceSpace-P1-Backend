package com.revature.facespace.controller;

import com.revature.facespace.model.Likes;
import com.revature.facespace.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/likes")
public class LikesController {
    @Autowired
    LikesRepository likesRepository;

    //Still need a way to verify user ID and post ID
    @PostMapping
    public int addLike(@RequestBody Likes like) {
        likesRepository.save(like);
        return likesRepository.countByPostId(like.getPostId());
    }

    @GetMapping("/{postId}")
    public int getPostLikes(@PathVariable Integer postId) {
        return likesRepository.countByPostId(postId);
    }
}
