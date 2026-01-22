package dev.bv_armstrong.practice_tracker.db;

import dev.bv_armstrong.practice_tracker.model.PracticeItem;

import java.util.List;

public interface PracticeItemDAO {

    int create(String name);

    PracticeItem getById(int id);

    List<PracticeItem> getAll();

}
