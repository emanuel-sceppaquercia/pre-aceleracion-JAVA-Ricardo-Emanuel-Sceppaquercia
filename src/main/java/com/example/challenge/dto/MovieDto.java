package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

public class MovieDto {

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String creationDate;

    @Getter @Setter
    private int score;

    @Getter @Setter
    private int genreId;

    public MovieDto(){

    }

    public MovieDto(String title, String image, String creationDate, int score){
        this.title = title;
        this.image = image;
        this.creationDate = creationDate;
        this.score = score;
    }

}
