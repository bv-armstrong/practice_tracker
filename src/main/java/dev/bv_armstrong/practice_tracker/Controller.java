package dev.bv_armstrong.practice_tracker;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/items")
public class Controller {

    private PracticeItemDAO dao;

    @Autowired
    public Controller(PracticeItemDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PracticeItem>> getAll() {
        return ResponseEntity.ok(dao.getAll());
    }

    @GetMapping("/")
    public ResponseEntity<PracticeItem> get(@RequestParam int id) {
        PracticeItem res = dao.getById(id);
        if (res == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dao.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<PracticeItem> createPracticeItem(@RequestAttribute PracticeItem item) {
        int id = dao.create(item.name());
        return ResponseEntity.ok(dao.getById(id));
    }

}
