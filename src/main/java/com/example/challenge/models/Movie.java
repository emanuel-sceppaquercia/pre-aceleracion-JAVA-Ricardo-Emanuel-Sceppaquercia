package com.example.challenge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "image")
    private String image;

    @Getter @Setter @Column(name = "creation_date")
    private  String creationDate;

    @Getter @Setter @Column(name = "score")
    private int score;

    @Getter @Setter
    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    public void setCharacter(Character character){
        if (this.characters == null){
            this.characters = new ArrayList<>();
        }
        this.characters.add(character);
    }

    public void setGenre(Genre genre){
        if (this.genres == null){
            this.genres = new ArrayList<>();
        }
        this.genres.add(genre);
    }

    public Movie(){

    }

    public Movie(String title, String image, String creationDate, int score){
        this.title = title;
        this.image = image;
        this.creationDate = creationDate;
        this.score = score;
    }

}
