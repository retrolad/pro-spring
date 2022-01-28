package com.retrolad.ch08.services;

import com.retrolad.ch08.entities.Developer;
import com.retrolad.ch08.entities.Game;

import java.util.List;

public interface GameService {
    List<Game> findByDeveloper(Developer developer);
    List<Game> findByTitle(String title);
}
