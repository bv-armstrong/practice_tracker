package dev.bv_armstrong.practice_tracker.api;

import dev.bv_armstrong.practice_tracker.db.PracticeItemDAO;
import dev.bv_armstrong.practice_tracker.model.PracticeItem;
import dev.bv_armstrong.practice_tracker.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/items")
public class ItemsController {

    private ItemService itemService;

    @Autowired
    public ItemsController(PracticeItemDAO practiceItemDAO) {
        this.itemService = new ItemService(practiceItemDAO);
    }

    @PostMapping("/")
    public ResponseEntity<PracticeItem> createPracticeItem(String name) {
        return ResponseEntity.ok(itemService.create(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PracticeItem>> getAll() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @GetMapping("/{id}/")
    public ResponseEntity<PracticeItem> get(@PathVariable Long id) {
        PracticeItem res = itemService.getById(id);
        if (res == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(res);
    }

}
