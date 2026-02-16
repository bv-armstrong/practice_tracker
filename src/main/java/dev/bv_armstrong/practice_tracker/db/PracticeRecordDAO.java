package dev.bv_armstrong.practice_tracker.db;

import dev.bv_armstrong.practice_tracker.model.PracticeRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface PracticeRecordDAO {

    void create(long itemId, LocalDateTime date, double score);

    List<PracticeRecord> getRecords(long itemId);

}
