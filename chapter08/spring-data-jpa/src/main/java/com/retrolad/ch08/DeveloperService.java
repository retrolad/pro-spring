package com.retrolad.ch08;

import com.retrolad.ch08.entities.Developer;

import java.util.Date;
import java.util.List;

public interface DeveloperService {
    List<Developer> findAll();
    List<Developer> findByName(String name);
    List<Developer> findByNameAndFound(String name, Date data);
}
