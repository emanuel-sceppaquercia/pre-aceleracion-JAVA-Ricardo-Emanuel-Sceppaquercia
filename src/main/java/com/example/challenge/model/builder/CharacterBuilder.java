package com.example.challenge.model.builder;

import com.example.challenge.dto.CharMovieListDto;
import com.example.challenge.dto.CharacterDto;
import com.example.challenge.dto.CharacterGetDto;
import com.example.challenge.models.Character;

public class CharacterBuilder {

    private Long id;
    private String name;
    private String image;
    private int age;
    private float weight;
    private String story;

    public CharacterBuilder withCharacterDto(CharacterDto characterDto){
        this.name = characterDto.getName();
        this.image = characterDto.getImage();
        this.age = characterDto.getAge();
        this.weight = characterDto.getWeight();
        this.story = characterDto.getStory();
        return this;
    }

    public CharacterBuilder withCharacter(Character character){
        this.id = character.getId();
        this.name = character.getName();
        this.image = character.getImage();
        this.age = character.getAge();
        this.weight = character.getWeight();
        this.story = character.getStory();
        return this;
    }

    public Character buildCharacter(){
        return new Character(this.name, this.image, this.age, this.weight, this.story);
    }

    public CharacterGetDto buildCharacterGetDto(){
        return new CharacterGetDto(this.id, this.name, this.image, this.age, this.weight, this.story);
    }

    public CharMovieListDto buildCharMovieListDto(){
        return new CharMovieListDto(this.id, this.name, this.image, this.age, this.weight, this.story);
    }

}
