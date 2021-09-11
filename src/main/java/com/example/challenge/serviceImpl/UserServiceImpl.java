package com.example.challenge.serviceImpl;


import com.example.challenge.repository.UserRepository;
import com.example.challenge.service.EmailService;
import com.example.challenge.service.UserService;
import com.example.challenge.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        emailService.sendEmail(user.getEmail());
    }

}
