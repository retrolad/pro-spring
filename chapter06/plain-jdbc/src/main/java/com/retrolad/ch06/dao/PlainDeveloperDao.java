package com.retrolad.ch06.dao;

import com.retrolad.ch06.entities.Developer;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainDeveloperDao implements DeveloperDao{

    private static Logger logger = LoggerFactory.getLogger(PlainDeveloperDao.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Problem loading DB driver!", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pro-spring",
                "postgres",
                "root");
    }

    private void closeConnection(Connection connection) {
        if(connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Problem closing connection to the database!", e);
        }
    }

    @Override
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from developer");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("id"));
                developer.setName(resultSet.getString("name"));
                developer.setFounded(resultSet.getDate("founded"));
                developers.add(developer);
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("Problem when executing SELECT", e);
        } finally {
            closeConnection(connection);
        }

        return developers;
    }

    @Override
    public List<Developer> findByName(String firstName) {
        List<Developer> developers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from developer where name = ?");
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("id"));
                developer.setName(resultSet.getString("name"));
                developer.setFounded(resultSet.getDate("founded"));
                developers.add(developer);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return developers;
    }

    @Override
    public void insert(Developer developer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT into developer (name, founded) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, developer.getName());
            statement.setDate(2, developer.getFounded());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if(generatedKeys.next()) {
                developer.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("Problem executing INSERT", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public String findNameById(Long id) {
        throw new NotImplementedException("findNameById");
    }

    @Override
    public void delete(Long developerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from developer where id = ?");
            statement.setLong(1, developerId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            logger.error("Problem executing DELETE");
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Developer developer) {
        throw new NotImplementedException("update");
    }

    @Override
    public List<Developer> findAllWithDetail() {
        throw new NotImplementedException("findAllWithDetail");
    }

    @Override
    public void insertWithDetail(Developer developer) {
        throw new NotImplementedException("insertWithDetail");
    }
}
