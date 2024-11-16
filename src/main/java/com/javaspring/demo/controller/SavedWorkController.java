package com.javaspring.demo.controller;

import com.javaspring.demo.entity.SavedWork;
import com.javaspring.demo.service.SavedWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saved-works")
public class SavedWorkController {

    @Autowired
    private SavedWorksService savedWorkService;

    // Додати твір у збережені
    @PostMapping
    public ResponseEntity<SavedWork> saveWork(@RequestParam Integer userId, @RequestParam Integer workId, @RequestParam(required = false) String description) {
        SavedWork savedWork = savedWorkService.saveWorkToUserList(userId, workId, description);
        return ResponseEntity.ok(savedWork);
    }

    // Перегляд збережених творів
    @GetMapping("/{userId}")
    public ResponseEntity<List<SavedWork>> getSavedWorks(@PathVariable Integer userId) {
        List<SavedWork> savedWorks = savedWorkService.getSavedWorksForUser(userId);
        return ResponseEntity.ok(savedWorks);
    }
}
