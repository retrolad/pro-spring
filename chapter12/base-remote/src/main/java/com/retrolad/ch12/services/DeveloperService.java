package com.retrolad.ch12.services;

import com.retrolad.ch12.entities.Developer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeveloperService {

    List<Developer> findAll();
    List<Developer> findByName(String name);
    Developer findById(Long id);
    Developer save(Developer developer);
    void delete(Developer developer);
}
