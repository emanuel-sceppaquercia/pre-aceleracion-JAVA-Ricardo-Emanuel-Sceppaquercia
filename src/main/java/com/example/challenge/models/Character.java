package com.example.challenge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Specifies that the class "User" is an entity, and it is mapped to a db table.
@Entity

// Specifies the db table name used for mapping.
@Table(name = "character")
public class Character {

    // @Id specifies the primary key.
    // @Column specifies the table column name.
    @Id
    @Getter @Setter @Column(name = "id")
    private int id;

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

    @Getter @Setter @Column(name = "movie_id")
    private int movieId;

}
