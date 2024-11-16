package com.javaspring.demo.repository;

import com.javaspring.demo.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
    List<WorkEntity> findByTitleContainingIgnoreCase(String title);
}
