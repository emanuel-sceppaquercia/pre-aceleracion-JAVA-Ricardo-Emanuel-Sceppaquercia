package com.example.challenge.serviceImpl;


import com.example.challenge.dto.*;
import com.example.challenge.model.builder.CharacterBuilder;
import com.example.challenge.model.builder.MovieBuilder;
import com.example.challenge.models.Movie;
import com.example.challenge.repository.CharacterRepository;
import com.example.challenge.repository.MovieRepository;
import com.example.challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.example.challenge.models.Character;
import org.springframework.stereotype.Service;


@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public List<CharListDto> getAllCharacters(){
        List<CharListDto> charListDto = new ArrayList<>();

        List<Character> list = characterRepository.findAll();

        for (Character c: list){
            charListDto.add(new CharListDto(c.getName(),c.getImage()));
        }
        return charListDto;
    }

    @Override
    public List<CharListDto> getAllCharacters(String name){
        List<CharListDto> charListDto = new ArrayList<>();

        List<Character> list = characterRepository.findByNameStartsWith(name);

        for (Character c: list){
            charListDto.add(new CharListDto(c.getName(),c.getImage()));
        }
        return charListDto;
    }

    @Override
    public List<CharListDto> getAllCharacters(int age) {
        List<CharListDto> charListDto = new ArrayList<>();

        List<Character> list = characterRepository.findByAge(age);

        for (Character c: list){
            charListDto.add(new CharListDto(c.getName(),c.getImage()));
        }
        return charListDto;
    }

    @Override
    public List<CharListDto> getAllCharacters(float weight) {
        List<CharListDto> charListDto = new ArrayList<>();

        List<Character> list = characterRepository.findByWeight(weight);

        for (Character c: list){
            charListDto.add(new CharListDto(c.getName(),c.getImage()));
        }
        return charListDto;
    }

    @Override
    public List<CharListDto> getAllCharsByMovieId(int movieId) {
        List<CharListDto> charList = new ArrayList<>();

        List<Character> list = characterRepository.findAll();
        for(Character c: list){
            for(Movie g: c.getMovies()){
                if(g.getId() == (long)movieId){
                    charList.add(new CharListDto(c.getName(), c.getImage()));
                    break;
                }
            }
        }
        return charList;
    }

    @Override
    public void saveCharacter(CharacterDto characterDto){
        Character newChar = new CharacterBuilder().withCharacterDto(characterDto).buildCharacter();

        Long movieId = (long) characterDto.getMovieId();
        newChar.setMovie(movieRepository.findById(movieId).get());

        characterRepository.save(newChar);
    }

    @Override
    public void deleteCharacter(int id) {
        characterRepository.deleteById((long)id);
    }

    @Override
    public void updateCharacter(int id, CharacterDto characterDto) {
        Character character = new CharacterBuilder().withCharacterDto(characterDto).buildCharacter();
        character.setId((long)id);
        character.setMovies(characterRepository.findById((long) id).get().getMovies());

        if (movieRepository.existsById((long)characterDto.getMovieId())){
            character.setMovie(movieRepository.findById((long)characterDto.getMovieId()).get());
        }
        characterRepository.save(character);
    }

    @Override
    public CharMovieListDto getCharacter(int id){
        Character newChar = characterRepository.findById((long)id).get();

        CharMovieListDto charMovieListDto = new CharacterBuilder().withCharacter(newChar).buildCharMovieListDto();

        List<Movie> list = newChar.getMovies();
        for (Movie movie: list){
            MovieGetDto movieGetDto = new MovieBuilder().withMovie(movie).buildMovieGetDto();
            charMovieListDto.setMovie(movieGetDto);
        }

        return charMovieListDto;
    }

    @Override
    public boolean exist(int id){
        return(characterRepository.existsById((long)id));
    }

}
