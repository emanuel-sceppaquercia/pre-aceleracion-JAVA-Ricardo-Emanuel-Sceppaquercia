package com.example.challenge.serviceImpl;

import com.example.challenge.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("emanuel@gmail.com");
        message.setTo(email);
        message.setSubject("Welcome!");
        message.setText("Your account has been successfully created.");
        mailSender.send(message);
    }

}