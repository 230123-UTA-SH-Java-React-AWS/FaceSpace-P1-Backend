package com.revature.facespace.controller;

import com.revature.facespace.model.Likes;
import com.revature.facespace.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class LikesController {
    @Autowired
    LikesRepository likesRepository;

    //Still need a way to verify user ID and post ID
    @PostMapping("/api/posts/likes")
    public int addLike(@RequestBody Likes like) {
        likesRepository.save(like);
        return likesRepository.countLikeByPostId(like.getPostId());
    }
}
