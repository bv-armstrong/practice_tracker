package dev.bv_armstrong.practice_tracker.db.test;

import dev.bv_armstrong.practice_tracker.db.PracticeRecordDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeRecord;

import java.time.LocalDateTime;
import java.util.List;

public class PracticeRecordDAOImpl implements PracticeRecordDAO {

    TestData data = TestData.getData();

    @Override
    public void create(long itemId, LocalDateTime date, double score) {

    }

    @Override
    public List<PracticeRecord> getRecords(long itemId) {
        return List.of();
    }
}
