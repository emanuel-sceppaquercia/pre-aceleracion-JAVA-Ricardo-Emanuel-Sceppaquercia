package com.example.challenge.model.builder;

import com.example.challenge.dto.MovieCharListDto;
import com.example.challenge.dto.MovieDto;
import com.example.challenge.dto.MovieGetDto;
import com.example.challenge.models.Movie;

public class MovieBuilder {

    private Long id;
    private String title;
    private String image;
    private String creationDate;
    private int score;

    public MovieBuilder withMovieDto(MovieDto movieDto){
        this.title = movieDto.getTitle();
        this.image = movieDto.getImage();
        this.creationDate = movieDto.getCreationDate();
        this.score = movieDto.getScore();
        return this;
    }

    public MovieBuilder withMovie(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.image = movie.getImage();
        this.creationDate = movie.getCreationDate();
        this.score = movie.getScore();
        return this;
    }

    public Movie buildMovie(){
        return new Movie(this.title, this.image, this.creationDate, this.score);
    }

    public MovieGetDto buildMovieGetDto(){
        return new MovieGetDto(this.id, this.title, this.image, this.creationDate, this.score);
    }

    public MovieCharListDto buildMovieCharListDto(){
        return new MovieCharListDto(this.id, this.title, this.image, this.creationDate, this.score);
    }


}
