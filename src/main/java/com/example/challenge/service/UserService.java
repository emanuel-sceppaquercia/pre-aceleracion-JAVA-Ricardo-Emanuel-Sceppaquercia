package com.example.challenge.service;

import com.example.challenge.models.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    boolean verifyUser(User user);

    List<User> getAll();
}
