package com.retrolad.ch09.services;

import com.retrolad.ch09.entities.Developer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeveloperService {

    List<Developer> findAll();
    Developer findById(Long id);
    Developer save(Developer developer);
    public int countAll();
}
