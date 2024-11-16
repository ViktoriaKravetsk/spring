package com.javaspring.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(SavedWorkId.class)
public class SavedWork {

    @Id
    private Integer userId;

    @Id
    private Integer workId;

    private String description;
    public SavedWork() {}

    public SavedWork(Integer userId, Integer workId, String description) {
        this.userId = userId;
        this.workId = workId;
        this.description = description;
    }
}
