package dev.bv_armstrong.practice_tracker.api;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.db.PracticeRecordDAO;
import dev.bv_armstrong.practice_tracker.db.test.PracticeItemDAOImpl;
import dev.bv_armstrong.practice_tracker.db.test.PracticeRecordDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PracticeItemDAO practiceItemDAO() {
        return new PracticeItemDAOImpl();
    }

    @Bean
    public PracticeRecordDAO practiceRecordDAO() {
        return new PracticeRecordDAOImpl();
    }
}
