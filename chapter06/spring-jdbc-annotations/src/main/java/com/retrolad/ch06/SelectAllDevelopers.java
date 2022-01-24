package com.retrolad.ch06;

import com.retrolad.ch06.entities.Developer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllDevelopers extends MappingSqlQuery<Developer> {

    private static final String SQL_SELECT_ALL_DEVELOPERS = "select * from developer";

    public SelectAllDevelopers(DataSource ds) {
        super(ds, SQL_SELECT_ALL_DEVELOPERS);
    }

    @Override
    protected Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();
        developer.setId(rs.getLong("id"));
        developer.setName(rs.getString("name"));
        developer.setFounded(rs.getDate("founded"));
        return developer;
    }
}
