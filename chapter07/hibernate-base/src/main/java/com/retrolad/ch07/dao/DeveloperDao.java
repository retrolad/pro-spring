package com.retrolad.ch07.dao;

import com.retrolad.ch07.entities.Developer;

import java.util.List;

public interface DeveloperDao {

    List<Developer> findAll();
    List<Developer> findAllWithGame();
    Developer findById(Long id);
    Developer save(Developer developer);
    void delete(Developer developer);

}
