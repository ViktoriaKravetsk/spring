package com.javaspring.demo.service;

import com.javaspring.demo.entity.SavedWork;
import com.javaspring.demo.repository.SavedWorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedWorksService {

    @Autowired
    private SavedWorksRepository savedWorkRepository;

    public SavedWork saveWorkToUserList(Integer userId, Integer workId, String description) {
        SavedWork savedWork = new SavedWork(userId, workId, description);
        return savedWorkRepository.save(savedWork);
    }

    public List<SavedWork> getSavedWorksForUser(Integer userId) {
        return savedWorkRepository.findByUserId(userId);
    }
}
