package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

public class CharListDto {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String image;

    public CharListDto(){

    }

    public CharListDto(String name, String image){
        this.name = name;
        this.image = image;
    }
}
