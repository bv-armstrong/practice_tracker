package dev.bv_armstrong.practice_tracker.service;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;

import java.util.List;

public class ItemService {

    private final PracticeItemDAO dao;

    public ItemService(PracticeItemDAO dao) {
        this.dao = dao;
    }

    public List<PracticeItem> getAll() {
        return dao.getAll();
    }

    public PracticeItem getById(long id) {
        return dao.getById(id);
    }

    public PracticeItem create(String name) {
        long id = dao.create(name);
        return dao.getById(id);
    }

}
