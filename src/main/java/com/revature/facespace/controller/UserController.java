package com.revature.facespace.controller;
import com.revature.facespace.model.User;
import com.revature.facespace.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    UserRepository userRepository;

    //Retrieving a specific user
    @GetMapping("/api/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
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

    /* 
     * Use postman to test and send in the body. To send over data to the server,
     * format of body to make it like this:
     * 
     *  {
     *      "id": 0,
     *      "emailAddress": "sean@gfake.com",
     *      "password": "password123",
     *      "given_name": "",
     *      "surname": "" 
     *  }
     * 
     * The only information we need is the "emailAddress" and "password" fields. The
     * rest of the fields could be whatever. Will return a user and populate those fields
     * from the database
     * 
    */
    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody User body) {
        try {
            User u = userRepository.findByEmailAddressAndPassword(body.getEmailAddress(), body.getPassword());
            if (!u.equals(null)) {
                return ResponseEntity.status(200).body(u);
            }
        } 
        catch (NullPointerException e) { //Only executes here if the user doesn't exist in the database
            e.printStackTrace();
        }
        return ResponseEntity.status(400).body(null);
        
    }
}
