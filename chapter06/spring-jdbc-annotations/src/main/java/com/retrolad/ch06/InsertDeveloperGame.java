package com.retrolad.ch06;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertDeveloperGame extends BatchSqlUpdate {

    private static final String SQL_INSERT_GAME = "insert into game(title, developer_id, release_date) " +
            "values(:title, :developer_id, :release_date)";

    private static final int BATCH_SIZE = 10;

    public InsertDeveloperGame(DataSource ds) {
        super(ds, SQL_INSERT_GAME);
        declareParameter(new SqlParameter("title", Types.VARCHAR));
        declareParameter(new SqlParameter("developer_id", Types.INTEGER));
        declareParameter(new SqlParameter("release_date", Types.DATE));

        setBatchSize(10);
    }
}
