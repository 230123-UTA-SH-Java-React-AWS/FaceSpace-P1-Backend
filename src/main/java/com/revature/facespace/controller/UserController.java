package com.revature.facespace.controller;
import com.revature.facespace.model.User;
import com.revature.facespace.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
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

    /* 
     * Use postman to test and send in the body. To send over data to the server,
     * format of body to make it like this:
     * 
     * <email>
     * <password>
     * 
     * Ideally I (Andrew) will need to change that String datatype to a JSON datatype since
     * the server expects that. I'll try to see if I can improve on this. 
     * 
    */
    @GetMapping("/api/login")
    public String login(@RequestBody String body) {
    
        // Login message if the user has just visited the page with no info sent to the server 
        if (body.isBlank()) {
            return "Welcome to the login page :3";
        }

        // Does the validation for the login credentials
        try {
            String[] a = body.split("\n");
            User u = userRepository.findByEmailAddressAndPassword(a[0].strip(), a[1].strip());
            
            // Need this check here to see if the server sent us a null value
            if (!u.equals(null)) {
                return "Welcome " + u.getGivenName() + " "  + u.getSurname();
            }
        }

        // For the String[]
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // See if the server sent us a null value back
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "Login Failed";
    }
}
