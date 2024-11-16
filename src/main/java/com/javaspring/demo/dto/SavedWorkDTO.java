package com.javaspring.demo.dto;

import com.javaspring.demo.entity.SavedWorkId;
import java.time.LocalDateTime;

public class SavedWorkDTO {
    private SavedWorkId id;
    private LocalDateTime savedAt;

    public SavedWorkDTO() {}

    public SavedWorkDTO(SavedWorkId id, LocalDateTime savedAt) {
        this.id = id;
        this.savedAt = savedAt;
    }

    public SavedWorkId getId() {
        return id;
    }

    public void setId(SavedWorkId id) {
        this.id = id;
    }

    public LocalDateTime getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(LocalDateTime savedAt) {
        this.savedAt = savedAt;
    }
}
