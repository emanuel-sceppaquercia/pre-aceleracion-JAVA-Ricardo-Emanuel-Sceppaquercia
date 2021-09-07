package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

public class MovieListDto {

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String creationDate;

    public MovieListDto(){

    }

    public MovieListDto(String name, String image, String creationDate){
        this.title = name;
        this.image = image;
        this.creationDate = creationDate;
    }

}
