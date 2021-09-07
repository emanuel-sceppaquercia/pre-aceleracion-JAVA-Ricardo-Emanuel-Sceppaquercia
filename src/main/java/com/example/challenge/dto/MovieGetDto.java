package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

public class MovieGetDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String creationDate;

    @Getter @Setter
    private int score;

    public MovieGetDto(){

    }

    public MovieGetDto(Long id, String title, String image, String creationDate, int score){
        this.id = id;
        this.title = title;
        this.image = image;
        this.creationDate = creationDate;
        this.score = score;
    }

}