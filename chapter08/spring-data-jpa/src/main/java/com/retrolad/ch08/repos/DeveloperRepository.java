package com.retrolad.ch08.repos;

import com.retrolad.ch08.entities.Developer;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    List<Developer> findByName(String name);
    List<Developer> findByNameAndFounded(String name, Date date);
}
