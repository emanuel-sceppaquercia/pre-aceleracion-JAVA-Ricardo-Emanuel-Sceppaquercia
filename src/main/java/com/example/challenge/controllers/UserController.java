package com.example.challenge.controllers;


import com.example.challenge.service.UserService;
import com.example.challenge.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // The annotation is used to map web requests to Spring Controller methods.
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){

        // Hashing password
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);
        userService.registerUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        if(userService.verifyUser(user)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


}
