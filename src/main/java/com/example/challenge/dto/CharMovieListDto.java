package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CharMovieListDto {

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

    @Getter @Setter
    private List<MovieGetDto> movies;

    public void setMovie(MovieGetDto movieGetDto){
        if(this.movies == null){
            movies = new ArrayList<>();
        }
        this.movies.add(movieGetDto);
    }

    public CharMovieListDto(Long id, String name, String image, int age, float weight, String story) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }
}
