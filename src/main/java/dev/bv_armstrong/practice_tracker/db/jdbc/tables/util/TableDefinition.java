package dev.bv_armstrong.practice_tracker.db.jdbc.tables.util;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TableDefinition<T> {

    public abstract String getName();

    public abstract List<SqlColumn<?>> getColumns();

    public abstract T mapToObject(ResultSet res) throws SQLException;

    public void initializeTable(Connection connection) throws SQLException {
        String sql = String.format("create table if not exists %s (%s);",
                getName(),
                getColumns().stream().map(SqlColumn::toSqlString).collect(Collectors.joining(", "))
        );
        connection.prepareStatement(sql).execute();
    }

    public <ColType> T queryForObjectByVal(JdbcTemplate sqlTemplate, SqlColumn<ColType> column, ColType val) {
        String sql = String.format("select * from %s where %s = ?;", getName(), column.getName());
        try {
            return sqlTemplate.queryForObject(sql, (res, row) -> mapToObject(res), val);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
