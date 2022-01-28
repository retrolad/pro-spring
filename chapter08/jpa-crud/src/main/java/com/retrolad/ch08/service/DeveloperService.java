package com.retrolad.ch08.service;

import com.retrolad.ch08.entities.Developer;

import java.util.List;

public interface DeveloperService {
    List<Developer> findAll();
    List<Developer> findAllWithAlbum();
    Developer findById(Long id);
    Developer save(Developer developer);
    void delete(Developer developer);
    List<Developer> findAllByNativeQuery();
    List<Developer> findByCriteriaQuery();
}
