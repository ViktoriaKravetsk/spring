package com.javaspring.demo.controller;

import com.javaspring.demo.entity.WorkEntity;
import com.javaspring.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import com.javaspring.demo.repository.WorkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public List<WorkEntity> getAllWorks() {
        return workService.getAllWorks();
    }

    @PostMapping
    public ResponseEntity<WorkEntity> addWork(@RequestBody WorkEntity work) {
        WorkEntity savedWork = workService.addWork(work);
        return ResponseEntity.ok(savedWork);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkEntity> updateWork(@PathVariable Long id, @RequestBody WorkEntity work) {
        if (!workService.getWorkById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        work.setId(id);
        WorkEntity updatedWork = workService.updateWork(id, work);
        return ResponseEntity.ok(updatedWork);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        if (!workService.getWorkById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        workService.deleteWork(id);
        return ResponseEntity.noContent().build();
    }

    // Пошук творів
    @GetMapping("/search")
    public List<WorkEntity> searchWorks(@RequestParam String query) {
        return workService.searchWorks(query);
    }

    // Перегляд детальної інформації про твір
    @GetMapping("/{id}")
    public ResponseEntity<WorkEntity> getWorkById(@PathVariable Long id) {
        return workService.getWorkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
