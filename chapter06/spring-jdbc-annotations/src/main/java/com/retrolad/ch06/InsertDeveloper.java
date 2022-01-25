package com.retrolad.ch06;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertDeveloper extends SqlUpdate {

    private static final String SQL_INSERT_DEVELOPER = "insert into developer(name, founded) " +
            "values(:name, :founded)";

    public InsertDeveloper(DataSource ds) {
        super(ds, SQL_INSERT_DEVELOPER);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("founded", Types.DATE));
        super.setGeneratedKeysColumnNames("id");
        super.setReturnGeneratedKeys(true);
    }
}
