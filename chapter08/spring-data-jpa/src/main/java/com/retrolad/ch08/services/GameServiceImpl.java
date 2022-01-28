package com.retrolad.ch08.services;

import com.retrolad.ch08.entities.Developer;
import com.retrolad.ch08.entities.Game;
import com.retrolad.ch08.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaGameService")
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Game> findByDeveloper(Developer developer) {
        return gameRepository.findByDeveloper(developer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Game> findByTitle(String title) {
        return gameRepository.findByTitle(title);
    }
}
