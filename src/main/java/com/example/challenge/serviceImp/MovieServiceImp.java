package com.example.challenge.serviceImp;

import com.example.challenge.dto.*;
import com.example.challenge.model.builder.CharacterBuilder;
import com.example.challenge.model.builder.MovieBuilder;
import com.example.challenge.models.Character;
import com.example.challenge.models.Genre;
import com.example.challenge.models.Movie;
import com.example.challenge.repository.GenreRepository;
import com.example.challenge.repository.MovieRepository;
import com.example.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<MovieListDto> getAllMovies(){
        List<MovieListDto> movieList = new ArrayList<>();

        List<Movie> list = movieRepository.findAll();
        for(Movie m: list){
            movieList.add(new MovieListDto(m.getTitle(),m.getImage(),m.getCreationDate()));
        }
        return movieList;
    }

    @Override
    public List<MovieListDto> getAllMovies(String name) {
        List<MovieListDto> movieList = new ArrayList<>();

        List<Movie> list = movieRepository.findByTitleStartsWith(name);
        for(Movie m: list){
            movieList.add(new MovieListDto(m.getTitle(),m.getImage(),m.getCreationDate()));
        }
        return movieList;
    }

    @Override
    public List<MovieListDto> getAllMoviesByGenre(Integer genreId){
        List<MovieListDto> movieList = new ArrayList<>();

        List<Movie> list = movieRepository.findAll();
        for(Movie m: list){
            for(Genre g: m.getGenres()){
                if(g.getId() == (long)genreId){
                    movieList.add(new MovieListDto(m.getTitle(),m.getImage(),m.getCreationDate()));
                    break;
                }
            }
        }
        return movieList;
    }

    @Override
    public List<MovieListDto> getAllMoviesByOrder(String order) {
        List<MovieListDto> movieList = new ArrayList<>();

        List<Movie> list = movieRepository.findAll();
        for(Movie m: list){
            movieList.add(new MovieListDto(m.getTitle(),m.getImage(),m.getCreationDate()));
        }
        if(order.equals("ASC")){ movieList.sort(Comparator.comparing(MovieListDto::getCreationDate)); }
        if(order.equals("DESC")){ movieList.sort(Comparator.comparing(MovieListDto::getCreationDate).reversed()); }

        return movieList;
    }

    @Override
    public void saveMovie(MovieDto movieDto){
        Movie newMovie = new MovieBuilder().withMovieDto(movieDto).buildMovie();
        Genre genre = genreRepository.findById((long)movieDto.getGenreId()).get();
        newMovie.setGenre(genre);

        movieRepository.save(newMovie);
    }

    @Override
    public void deleteMovie(int id){
        movieRepository.deleteById((long) id);
    }

    @Override
    public void updateMovie(int id, MovieDto movieDto){
        Movie movie = new MovieBuilder().withMovieDto(movieDto).buildMovie();
        movie.setId((long)id);

        movie.setGenres(movieRepository.findById((long) id).get().getGenres());

        if(genreRepository.existsById((long) movieDto.getGenreId())){
            movie.setGenre(genreRepository.findById((long)movieDto.getGenreId()).get());
        }
        movieRepository.save(movie);
    }

    @Override
    public MovieCharListDto getMovie(int id){
        Movie movie = movieRepository.findById((long)id).get();

        MovieCharListDto movieCharListDto = new MovieBuilder().withMovie(movie).buildMovieCharListDto();

        List<Character> list = movie.getCharacters();
        for(Character c: list){
            CharacterGetDto characterGetDto = new CharacterBuilder().withCharacter(c).buildCharacterGetDto();
            movieCharListDto.setCharacter(characterGetDto);
        }
        return movieCharListDto;
    }

    @Override
    public boolean exist(int id){
        return movieRepository.existsById((long) id);
    }



}
