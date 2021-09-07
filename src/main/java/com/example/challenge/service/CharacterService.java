package com.example.challenge.service;


import java.util.List;

import com.example.challenge.dto.CharListDto;
import com.example.challenge.dto.CharMovieListDto;
import com.example.challenge.dto.CharacterDto;

public interface CharacterService {

    List<CharListDto> getAllCharacters();
    List<CharListDto> getAllCharacters(String name);
    List<CharListDto> getAllCharacters(int age);
    List<CharListDto> getAllCharacters(float weight);
    List<CharListDto> getAllCharsByMovieId(int movieId);

    void saveCharacter(CharacterDto characterDto);

    void deleteCharacter(int id);

    void updateCharacter(int id,CharacterDto characterDto);

    CharMovieListDto getCharacter(int id);

    boolean exist(int id);

}
