package com.javaspring.demo.service;

import com.javaspring.demo.entity.WorkEntity;
import com.javaspring.demo.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    // Додати новий твір
    public WorkEntity addWork(WorkEntity work) {
        return workRepository.save(work);
    }

    // Отримати всі твори
    public List<WorkEntity> getAllWorks() {
        return workRepository.findAll();
    }

    // Отримати твір за ID
    public Optional<WorkEntity> getWorkById(Long id) {
        return workRepository.findById(id);
    }

    // Оновити твір
    public WorkEntity updateWork(Long id, WorkEntity updatedWork) {
        updatedWork.setId(id);
        return workRepository.save(updatedWork);
    }

    // Видалити твір
    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }

    // Пошук творів
    public List<WorkEntity> searchWorks(String query) {
        return workRepository.findByTitleContainingIgnoreCase(query);
    }
}
