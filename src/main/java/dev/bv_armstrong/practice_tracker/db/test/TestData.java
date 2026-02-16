package dev.bv_armstrong.practice_tracker.db.test;

import dev.bv_armstrong.practice_tracker.model.PracticeItem;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private static final TestData singleton = new TestData();

    public static TestData getData() {
        return singleton;
    }

    List<PracticeItem> items = new ArrayList<>();
    int nextId = 0;

    private TestData() { };

    public long addItem(String name) {
        int id = nextId++;
        items.add(new PracticeItem(id, name));
        return id;
    }

    public PracticeItem getItemById(long id) {
        return items.stream()
                .filter(item -> item.id() == id)
                .findAny()
                .orElse(null);
    }

    public List<PracticeItem> getAllItems() {
        return items;
    }
}
