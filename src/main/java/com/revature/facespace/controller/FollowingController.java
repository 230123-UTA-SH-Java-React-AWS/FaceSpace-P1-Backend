package com.revature.facespace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.facespace.model.Following;
import com.revature.facespace.repository.FollowingRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class FollowingController {
    @Autowired
    FollowingRepository followingRepository;

    @GetMapping("/api/followings/{userId}")
    public List<Following> findAllFollowingsByFollowerId(@PathVariable Integer userId) {
        return followingRepository.findAllFollowingsByFollowerId(userId);
    }
}