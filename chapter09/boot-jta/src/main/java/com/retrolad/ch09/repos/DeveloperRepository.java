package com.retrolad.ch09.repos;

import com.retrolad.ch09.entities.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
