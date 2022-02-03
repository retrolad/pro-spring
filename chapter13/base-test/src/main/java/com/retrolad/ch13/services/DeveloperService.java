package com.retrolad.ch13.services;

import com.retrolad.ch13.entities.Developer;

import java.util.List;

public interface DeveloperService {

    List<Developer> findAll();
    List<Developer> findByName(String name);
    Developer findById(Long id);
    Developer save(Developer developer);
    void delete(Developer developer);
}
