package com.retrolad.ch06;

import com.retrolad.ch06.config.DbConfig;
import com.retrolad.ch06.entities.Developer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DbConfigTest {

    private static Logger logger = LoggerFactory.getLogger(DbConfigTest.class);

    @Test
    public void testOne() {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:spring/drivermanager-cfg-01.xml");
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);

        assertNotNull(dataSource);
        testDataSource(dataSource);
        logger.debug("TESTED");
    }

    @Test
    public void testTwo() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
    }

    public void testDataSource(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from developer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("id"));
                developer.setName(resultSet.getString("name"));
                developer.setFounded(resultSet.getDate("founded"));
                logger.debug(developer.toString());
//                int mockVal = resultSet.getInt("1");
//                assertEquals(1, mockVal);
            }
        } catch (SQLException e) {
            logger.debug("Something unexpected happened.", e);
        }
    }
}
