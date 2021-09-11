package com.example.challenge.service;

import com.example.challenge.dto.*;

import java.util.List;

public interface MovieService {

    List<MovieListDto> getAllMovies();
    List<MovieListDto> getAllMovies(String name);
    List<MovieListDto> getAllMoviesByGenre(Integer genreId);
    List<MovieListDto> getAllMoviesByOrder(String order);

    void saveMovie(MovieDto movieDto);

    void deleteMovie(int id);

    void updateMovie(int id, MovieDto movieDto);

    MovieCharListDto getMovie(int id);

    boolean exist(int id);
}
