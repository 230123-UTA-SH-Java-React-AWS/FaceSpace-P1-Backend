package com.revature.facespace.controller;
import com.revature.facespace.model.User;
import com.revature.facespace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@CrossOrigin("") -- this is what allows front end to use same port to get
// data. Will use later
public class UserController {
    @Autowired
    UserRepository userRepository;

    //Retrieving a specific user
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.getById(id);
    }

    //Registration/creating a new user
    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
       return userRepository.save(user);
    }

    //TODO: Password reset/change. PATCH request may also work here
    @PutMapping("/api/users/{id}")
    public String changePassword(@PathVariable Integer id,
                                 @RequestBody User user) {
        Optional<User> tempUser = userRepository.findById(id);

        if (tempUser.isPresent()) {
            userRepository.save(user);
            return "Password successfully changed!";
        }
        return "An error occurred.";
    }

    //TODO: Login
    @PostMapping("/api/user/{id}")
    public String login() {
        return null;
    }
}
