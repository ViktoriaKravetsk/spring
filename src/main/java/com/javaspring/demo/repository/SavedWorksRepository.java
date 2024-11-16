package com.javaspring.demo.repository;

import com.javaspring.demo.entity.SavedWork;
import com.javaspring.demo.entity.SavedWorkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SavedWorksRepository extends JpaRepository<SavedWork, SavedWorkId> {
    List<SavedWork> findByUserId(Integer userId);
}
