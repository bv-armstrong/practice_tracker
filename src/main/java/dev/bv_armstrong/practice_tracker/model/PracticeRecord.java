package dev.bv_armstrong.practice_tracker.model;

import java.time.LocalDateTime;

public record PracticeRecord(
        PracticeItem item,
        LocalDateTime date,
        double rating
) {
}
