package com.revature.facespace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.facespace.model.Following;
import com.revature.facespace.repository.FollowingRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/followings")
public class FollowingController {
    @Autowired
    FollowingRepository followingRepository;


        /* 
     * Format
     * {
     *  "id": 0,
     *  "follower": (id of person logged in)
     *  "following" (id of the person being followed)
     * }
    */
    @GetMapping("/{userId}")
    public List<Following> findAllFollowingsByFollowerId(@PathVariable Integer userId) {
        return followingRepository.findAllFollowingsByFollowerId(userId);
    }


    /* 
     * Format
     * {
     *  "id": 0,
     *  "follower": (id of person logged in)
     *  "following" (id of the person being followed)
     * }
    */
    @PostMapping
    public Following addFollowing(@RequestBody Following following) {
       return followingRepository.save(following);
    }
}