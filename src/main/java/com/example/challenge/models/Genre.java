package com.example.challenge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "image")
    private String image;

    @Getter @Setter
    @ManyToMany(mappedBy = "genres")
    private List<Movie> moviesGenre;

    public void setMovie(Movie movie){
        if(this.moviesGenre == null){
            this.moviesGenre = new ArrayList<>();
        }
        this.moviesGenre.add(movie);
    }


}