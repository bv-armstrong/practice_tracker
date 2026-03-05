package dev.bv_armstrong.practice_tracker.db.jdbc.tables.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;

public class SqlColumnBuilder<T> {

    private static abstract class SqlColumnImpl<T> implements SqlColumn<T> {

        private final String name;
        private final String sqlType;

        private boolean autoincrement;
        private boolean primaryKey;

        private SqlColumnImpl(String name, String sqlType) {
            this.name = name;
            this.sqlType = sqlType;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toSqlString() {
            StringJoiner sj = new StringJoiner(" ");
            sj.add(name);
            sj.add(sqlType);
            if (primaryKey) sj.add("primary key");
            if (autoincrement) sj.add("autoincrement");
            return sj.toString();
        }

    }

    public static SqlColumnBuilder<Long> numberColumn(String name) {
        return new SqlColumnBuilder<>(new SqlColumnImpl<>(name, "integer") {

            @Override
            public Long getFromResultSet(ResultSet resultSet) throws SQLException {
                return resultSet.getLong(name);

            }
        });
    }

    public static SqlColumnBuilder<String> textColumn(String name) {
        return new SqlColumnBuilder<>(new SqlColumnImpl<>(name, "text") {

            @Override
            public String getFromResultSet(ResultSet resultSet) throws SQLException {
                return resultSet.getString(name);
            }

        });
    }


    private final SqlColumnImpl<T> col;

    private SqlColumnBuilder(SqlColumnImpl<T> col) {
        this.col = col;
    }

    public SqlColumnBuilder<T> autoincrement() {
        this.col.autoincrement = true;
        return this;
    }

    public SqlColumnBuilder<T> primaryKey() {
        this.col.primaryKey = true;
        return this;
    }

    public SqlColumn<T> build() {
        return col;
    }

}
