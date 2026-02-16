package dev.bv_armstrong.practice_tracker.db;

import dev.bv_armstrong.practice_tracker.model.PracticeItem;

import java.util.List;

public interface PracticeItemDAO {

    long create(String name);

    PracticeItem getById(long id);

    List<PracticeItem> getAll();

}
