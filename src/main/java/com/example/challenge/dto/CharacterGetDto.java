package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

public class CharacterGetDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private int age;

    @Getter @Setter
    private float weight;

    @Getter @Setter
    private String story;

    public CharacterGetDto(){

    }

    public CharacterGetDto(Long id, String name, String image, int age, float weight, String story){
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

}