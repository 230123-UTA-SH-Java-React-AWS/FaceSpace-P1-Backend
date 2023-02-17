package com.revature.facespace.controller;
import com.revature.facespace.model.User;
import com.revature.facespace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.getById(id);
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }


}
