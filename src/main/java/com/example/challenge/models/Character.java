package com.example.challenge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "image")
    private String image;

    @Getter @Setter @Column(name = "age")
    private int age;

    @Getter @Setter @Column(name = "weight")
    private float weight;

    @Getter @Setter @Column(name = "story")
    private String story;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
        name = "movie_character",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

    // Método para insertar un objeto de tipo Movie a la lista.
    public void setMovie(Movie movie){
        // Si la lista no contiene elementos, se crea un ArrayList para insertar posteriormente elementos.
        if(this.movies == null){
            this.movies = new ArrayList<>();
        }
        this.movies.add(movie);
    }


    public Character(){

    }

    public Character(String name, String image, int age, float weight, String story){
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.story = story;
    }

}
