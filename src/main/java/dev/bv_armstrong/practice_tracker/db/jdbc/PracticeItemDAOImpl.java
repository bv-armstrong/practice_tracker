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
//    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    public PracticeItemDAOImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        inserter = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(ID_COL.getName());
//        jdbcAggregateTemplate = jdbcTemplate;
    }

    @Override
    public long create(String name) {
        Map<String, Object> parameters = Map.of(NAME_COL.getName(), name);
        Number id = inserter.executeAndReturnKey(parameters);
        return id.longValue();
//        PracticeItem item = new PracticeItem(name);
//        return jdbcAggregateTemplate.save(item).id();  // TODO: Return object?
    }

    @Override
    public PracticeItem getById(long id) {
//        return jdbcAggregateTemplate.findById(id, PracticeItem.class);
        return FUNCTIONS.queryForObjectByVal(template, ID_COL, id);
    }

    @Override
    public List<PracticeItem> getAll() {
//        return jdbcAggregateTemplate.findAll(PracticeItem.class);
        return FUNCTIONS.queryForAll(template);
    }
}
