package com.revature.facespace.controller;
import com.revature.facespace.model.User;
import com.revature.facespace.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    //Retrieving a specific user
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    //Registration/creating a new user
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
       return userRepository.save(user);
    }

    /*
     *
     * Changing password feature is completed based on users id (on the endpoint)
     * 
     * Proper format:
     * "password": "somePassword1234"
     * 
     * 
     * This format will return a "400 Bad Request" because user shouldn't be able to have an empty password
     * "password": ""
     * 
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> changeUserPassword(@PathVariable int id, @RequestBody User enteredPassword) {
        Optional<User> userExist = userRepository.findById(id);

        /*
         * If a user doesn't exist based on their id,
         * then it will result in a 404 Not Found
         */
        if (userExist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        User user = userExist.get();
        login(user); // User is obviously logged in at this point

        String newPassword = enteredPassword.getPassword(); // Storing the newly entered password from Postman

        /*
         * If a user attempts to enter an empty password,
         * then it will result in a 404 Bad Request
         */
        if (newPassword == null || newPassword.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        user.setPassword(newPassword);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    /* 
     * Use postman to test and send in the body. To send over data to the server,
     * format of body to make it like this:
     * 
     *  {
     *      "id": 0,
     *      "emailAddress": "sean@gfake.com",
     *      "password": "password123",
     *      "givenName": "",
     *      "surname": "" 
     *  }
     * 
     * The only information we need is the "emailAddress" and "password" fields. The
     * rest of the fields could be whatever. Will return a user and populate those fields
     * from the database
     * 
    */
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User body) {
        try {
            User u = userRepository.findByEmailAddressAndPassword(body.getEmailAddress(), body.getPassword());
            if (!u.equals(null)) {
                u.setLoggedIn(true);
                return ResponseEntity.status(200).body(u);
            }
        } 
        catch (NullPointerException e) { //Only executes here if the user doesn't exist in the database
            e.printStackTrace();
        }
        return ResponseEntity.status(400).body(null);
        
    }

    /*
     * Format for the JSON should be as similar to the login method
     *  {
     *      "id": 0,
     *      "emailAddress": "",
     *      "password": "",
     *      "givenName": "Sean",
     *      "surname": "Sean" 
     *  }
     * 
     *  Note that the "givenName" and "surname" fields are the only important data 
     *  we care so the code can search up both of those columns in the database. 
     *  The "id", "emailAddress", and "password" fields do not matter
     */
    @PostMapping("/search_friends")
    public ResponseEntity<Set<User>> searchUsers(@RequestBody User body) {

        // Grabs unique users from the database
        Set<User> users = new HashSet<User>(userRepository.findByGivenName(body.getGivenName()));
        users.addAll(userRepository.findBySurname(body.getSurname()));

        // Scrub emails and passwords of the users
        users.forEach((u) -> u.setEmailAddress(""));
        users.forEach((u) -> u.setPassword(""));

        // Returns the set of users
        return ResponseEntity.status(200).body(users);
    }
}