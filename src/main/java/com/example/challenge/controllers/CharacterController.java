package com.example.challenge.controllers;


import com.example.challenge.dto.CharMovieListDto;
import com.example.challenge.dto.CharacterDto;
import com.example.challenge.models.Character;
import com.example.challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<?> getAllCharacters(@RequestParam (required = false) String name,
                                              @RequestParam (required = false) Integer age,
                                              @RequestParam (required = false) Float weight,
                                              @RequestParam (required = false) Integer movies){
        if(characterService.getAllCharacters().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else{
            if(name != null){ return new ResponseEntity<>(characterService.getAllCharacters(name), HttpStatus.OK); }
            if(age != null){ return new ResponseEntity<>(characterService.getAllCharacters(age), HttpStatus.OK); }
            if(weight != null){ return new ResponseEntity<>(characterService.getAllCharacters(weight), HttpStatus.OK); }
            if(movies != null){ return new ResponseEntity<>(characterService.getAllCharsByMovieId(movies), HttpStatus.OK); }
        }
        return new ResponseEntity<>(characterService.getAllCharacters(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCharacter(@RequestBody CharacterDto characterDto){
        characterService.saveCharacter(characterDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable int id){
        if(characterService.exist(id)){
            characterService.deleteCharacter(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCharacter(@PathVariable int id,@RequestBody CharacterDto characterDto){
        if(characterService.exist(id)){
            characterService.updateCharacter(id, characterDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCharacter(@PathVariable int id){
        if(characterService.exist(id)){
            CharMovieListDto charMovieListDto = characterService.getCharacter(id);
            return new ResponseEntity<>(charMovieListDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

}
