package dev.bv_armstrong.practice_tracker.db.jdbc.tables;

import dev.bv_armstrong.practice_tracker.db.jdbc.tables.util.SqlColumn;
import dev.bv_armstrong.practice_tracker.db.jdbc.tables.util.SqlColumnBuilder;
import dev.bv_armstrong.practice_tracker.db.jdbc.tables.util.TableDefinition;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PracticeItemTableDefinition {

    String TABLE_NAME = "practice_item";

    SqlColumn<Long> ID_COL = SqlColumnBuilder.numberColumn("id").autoincrement().primaryKey().build();
    SqlColumn<String> NAME_COL = SqlColumnBuilder.textColumn("name").build();

    TableDefinition<PracticeItem> FUNCTIONS = new TableDefinition<PracticeItem>() {
        @Override
        public String getName() {
            return TABLE_NAME;
        }

        @Override
        public List<SqlColumn<?>> getColumns() {
            return List.of(ID_COL, NAME_COL);
        }

        @Override
        public PracticeItem mapToObject(ResultSet resultSet) throws SQLException {
            return new PracticeItem(
                    ID_COL.getFromResultSet(resultSet),
                    NAME_COL.getFromResultSet(resultSet)
            );
        }
    };

}
