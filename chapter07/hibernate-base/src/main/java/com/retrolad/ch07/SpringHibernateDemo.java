package com.retrolad.ch07;

import com.retrolad.ch07.config.AppConfig;
import com.retrolad.ch07.dao.DeveloperDao;
import com.retrolad.ch07.entities.City;
import com.retrolad.ch07.entities.Developer;
import com.retrolad.ch07.entities.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.Set;

public class SpringHibernateDemo {

    private static final Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        DeveloperDao developerDao = ctx.getBean(DeveloperDao.class);

        Developer developer = developerDao.findById(4L);
        logger.info(developer.toString());

//        List<Developer> developers = developerDao.findAllWithGame();
//        listDevelopersWithGame(developers);
    }

    private static void listDevelopersWithGame(List<Developer> developers) {
        logger.info("---- List developers with games");
        for (Developer developer : developers) {
            logger.info(developer.toString());
            Set<Game> games = developer.getGames();
            if(games != null) {
                for(Game game : games) {
                    logger.info("\t" + game.toString());
                }
            }
            if(developer.getCities() != null) {
                for (City city : developer.getCities()) {
                    logger.info("\t" + city.toString());
                }
            }
        }
    }
}
