package dev.bv_armstrong.practice_tracker.db.test;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracticeItemDAOImpl implements PracticeItemDAO {

    TestData data = TestData.getData();

    @Override
    public long create(String name) {
        return data.addItem(name);
    }

    @Override
    public PracticeItem getById(long id) {
        return data.getItemById(id);
    }

    @Override
    public List<PracticeItem> getAll() {
        return data.getAllItems();
    }
}
