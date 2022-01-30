package com.retrolad.ch09.services;

import com.retrolad.ch09.entities.Developer;

public interface DeveloperService {

    Developer save(Developer developer);
    long count();
}
