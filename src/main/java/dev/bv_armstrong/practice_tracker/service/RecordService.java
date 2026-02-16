package dev.bv_armstrong.practice_tracker.service;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.db.PracticeRecordDAO;

import java.time.LocalDateTime;

public class RecordService {

    PracticeItemDAO itemDAO;
    PracticeRecordDAO recordDAO;

    public RecordService(PracticeItemDAO itemDAO, PracticeRecordDAO recordDAO) {
        this.itemDAO = itemDAO;
        this.recordDAO = recordDAO;
    }

    public void createRecord(Long itemId, double score) {
        if (score < 0 || score > 1) throw new IllegalArgumentException("Score must be between 0 and 1");
        if (itemDAO.getById(itemId) == null) throw new IllegalArgumentException("Invalid Practice Item ID");

        recordDAO.create(itemId, LocalDateTime.now(), score);
    }
}
