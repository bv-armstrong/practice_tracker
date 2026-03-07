package dev.bv_armstrong.practice_tracker.spring;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.db.jdbc.PracticeItemDAOImpl;
import dev.bv_armstrong.practice_tracker.db.jdbc.tables.PracticeItemTableDefinition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("dev.bv_armstrong.practice_tracker.db.jdbc")
public class Config {


    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new SQLiteDataSource();
    }

    @Bean
    public DatabasePopulator populateDatabase() {
        return PracticeItemTableDefinition.FUNCTIONS::initializeTable;
    }

    @Bean
    public DataSourceInitializer initializeDb(DataSource dataSource, DatabasePopulator populator) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(populator);
        return initializer;
    }

    @Bean
    public PracticeItemDAO practiceItemDAO(DataSource dataSource) {
        return new PracticeItemDAOImpl(dataSource);
    }

//    @Bean
//    public PracticeRecordDAO practiceRecordDAO() {
//        return new PracticeRecordDAOImpl();
//    }

}
