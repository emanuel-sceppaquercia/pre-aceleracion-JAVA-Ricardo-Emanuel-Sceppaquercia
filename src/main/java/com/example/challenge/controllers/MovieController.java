package com.example.challenge.controllers;


import com.example.challenge.dto.CharMovieListDto;
import com.example.challenge.dto.CharacterDto;
import com.example.challenge.dto.MovieCharListDto;
import com.example.challenge.dto.MovieDto;
import com.example.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAllMovies(@RequestParam (required = false) String name,
                                          @RequestParam (required = false) Integer genre,
                                          @RequestParam (required = false) String order) {

        if(movieService.getAllMovies().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else{
            if(name != null) { return new ResponseEntity<>(movieService.getAllMovies(name),HttpStatus.OK); }
            if(genre != null) { return new ResponseEntity<>(movieService.getAllMoviesByGenre(genre),HttpStatus.OK); }
            if(order != null) { return new ResponseEntity<>(movieService.getAllMoviesByOrder(order),HttpStatus.OK); }
        }
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody MovieDto movieDto){
        movieService.saveMovie(movieDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        if(movieService.exist(id)){
            movieService.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable int id,@RequestBody MovieDto movieDto){
        if(movieService.exist(id)){
            movieService.updateMovie(id, movieDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getMovie(@PathVariable int id){
        if(movieService.exist(id)){
            MovieCharListDto movieCharListDto = movieService.getMovie(id);
            return new ResponseEntity<>(movieCharListDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
