package com.example.challenge.controllers;


import com.example.challenge.dao.UserDao;
import com.example.challenge.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    // The annotation is used to map web requests to Spring Controller methods.
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create();
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);

        userDao.registerUser(user);
    }

    @RequestMapping(value = "auth/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
        if(userDao.verifyUser(user)){
            return "OK";
        }
        return "FAIL";
    }



}
