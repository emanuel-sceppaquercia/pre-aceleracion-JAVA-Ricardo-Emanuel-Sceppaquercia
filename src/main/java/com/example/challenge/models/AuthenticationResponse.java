package com.example.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationResponse {

    @Getter @Setter
    private String jwt;

}
