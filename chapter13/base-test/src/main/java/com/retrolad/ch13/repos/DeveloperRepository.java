package com.retrolad.ch13.repos;

import com.retrolad.ch13.entities.Developer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    List<Developer> findByName(String name);
}
