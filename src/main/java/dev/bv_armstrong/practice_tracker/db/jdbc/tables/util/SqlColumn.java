package dev.bv_armstrong.practice_tracker.db.jdbc.tables.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlColumn<T> {

    String getName();

    String toSqlString();

    T getFromResultSet(ResultSet resultSet) throws SQLException;

}
