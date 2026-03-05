package dev.bv_armstrong.practice_tracker.db.jdbc;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static dev.bv_armstrong.practice_tracker.db.jdbc.tables.PracticeItemTableDefinition.*;

public class PracticeItemDAOImpl implements PracticeItemDAO {

    private final SimpleJdbcInsert inserter;
    private final JdbcTemplate template;

    public PracticeItemDAOImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        inserter = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(ID_COL.getName());
    }

    @Override
    public long create(String name) {
//        SqlParameterSource parameters = new BeanPropertySqlParameterSource(actor);
        Map<String, Object> parameters = Map.of(NAME_COL.getName(), name);
        Number id = inserter.executeAndReturnKey(parameters);
        return id.longValue();
    }

    @Override
    public PracticeItem getById(long id) {
        return FUNCTIONS.queryForObjectByVal(template, ID_COL, id);
    }

    @Override
    public List<PracticeItem> getAll() {
        return List.of();
    }
}
