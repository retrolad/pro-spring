package com.retrolad.ch06.dao;

import com.retrolad.ch06.entities.Developer;

import java.util.List;

public interface DeveloperDao {
    List<Developer> findAll();
    List<Developer> findByName(String firstName);
    String findNameById(Long id);
    void insert(Developer developer);
    void update(Developer developer);
    void delete(Long developerId);
    List<Developer> findAllWithGames();
    void insertWithGames(Developer developer);
}
