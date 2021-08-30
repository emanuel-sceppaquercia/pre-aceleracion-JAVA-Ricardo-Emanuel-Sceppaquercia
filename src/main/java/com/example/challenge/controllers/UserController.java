package com.example.challenge.controllers;


import com.example.challenge.dao.UserDao;
import com.example.challenge.models.User;
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
    @RequestMapping(value = "user")
    public User getUser(){
        User user = new User();

        return user;
    }

    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        userDao.registerUser(user);
    }




}
