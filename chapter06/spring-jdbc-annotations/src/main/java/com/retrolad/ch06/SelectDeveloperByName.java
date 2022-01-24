package com.retrolad.ch06;

import com.retrolad.ch06.entities.Developer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectDeveloperByName extends MappingSqlQuery<Developer> {

    private static final String SQL_FIND_BY_NAME = "select * from developer where name = :name";

    public SelectDeveloperByName(DataSource ds) {
        super(ds, SQL_FIND_BY_NAME);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
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
