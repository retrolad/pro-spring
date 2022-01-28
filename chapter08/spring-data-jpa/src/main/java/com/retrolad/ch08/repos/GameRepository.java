package com.retrolad.ch08.repos;

import com.retrolad.ch08.entities.Developer;
import com.retrolad.ch08.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByDeveloper(Developer developer);

    @Query("select g from Game g where g.title like %:title%")
    List<Game> findByTitle(@Param("title") String title);
}
