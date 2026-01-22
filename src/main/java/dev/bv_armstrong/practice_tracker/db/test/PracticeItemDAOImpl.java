package dev.bv_armstrong.practice_tracker.db.test;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PracticeItemDAOImpl implements PracticeItemDAO {

    List<PracticeItem> items = new ArrayList<>();
    int nextId = 0;

    @Override
    public int create(String name) {
        int id = nextId++;
        items.add(new PracticeItem(id, name));
        return id;
    }

    @Override
    public PracticeItem getById(int id) {
        return items.stream()
                .filter(item -> item.id() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<PracticeItem> getAll() {
        return items;
    }

}
