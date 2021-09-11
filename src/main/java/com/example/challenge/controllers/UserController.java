package com.example.challenge.controllers;


import com.example.challenge.dto.UserDto;
import com.example.challenge.models.AuthenticationResponse;
import com.example.challenge.service.UserService;
import com.example.challenge.models.User;
import com.example.challenge.serviceImpl.UserDetailsServiceImpl;
import com.example.challenge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    // The annotation is used to map web requests to Spring Controller methods.
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        userService.registerUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        UserDetails user = userDetailsService.loadUserByUsername(userDto.getUsername());
        String jwt = jwtUtil.generateToken(user);
        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }

}
