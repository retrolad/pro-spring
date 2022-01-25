package com.retrolad.ch06;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateDeveloper extends SqlUpdate {

    private static final String SQL_UPDATE_DEVELOPER =
            "update developer " +
            "set name=:name, " +
            "founded=:founded " +
            "where id=:id";

    public UpdateDeveloper(DataSource ds) {
        super(ds, SQL_UPDATE_DEVELOPER);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("founded", Types.DATE));
        super.declareParameter(new SqlParameter("name", Types.INTEGER));
    }
}
