package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class MovieCharListDto {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private  String creationDate;

    @Getter @Setter
    private int score;

    @Getter @Setter
    private List<CharacterGetDto> characters;

    public void setCharacter(CharacterGetDto characterGetDto){
        if(this.characters == null){
            characters = new ArrayList<>();
        }
        this.characters.add(characterGetDto);
    }


    public MovieCharListDto(){

    }

    public MovieCharListDto(Long id, String title, String image, String creationDate, int score) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.creationDate = creationDate;
        this.score = score;
    }

}
