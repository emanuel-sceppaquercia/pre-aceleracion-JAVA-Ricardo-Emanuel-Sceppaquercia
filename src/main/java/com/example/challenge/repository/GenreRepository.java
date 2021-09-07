package com.example.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.challenge.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
