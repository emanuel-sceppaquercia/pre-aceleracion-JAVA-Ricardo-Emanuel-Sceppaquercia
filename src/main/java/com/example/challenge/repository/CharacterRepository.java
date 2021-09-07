package com.example.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.challenge.models.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByNameStartsWith(String name);
    List<Character> findByAge(int age);
    List<Character> findByWeight(float weight);

}
