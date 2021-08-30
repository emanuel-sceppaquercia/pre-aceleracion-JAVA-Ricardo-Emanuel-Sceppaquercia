package com.example.challenge.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


// Specifies that the class "User" is an entity, and it is mapped to a db table.
@Entity

// Specifies the db table name used for mapping.
@Table(name = "user")
public class User {

    // @Id specifies the primary key.
    // @Column specifies the table column name.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private int id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

}
