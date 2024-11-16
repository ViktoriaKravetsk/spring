package com.javaspring.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class SavedWorkId implements Serializable {
    private Integer userId;
    private Integer workId;

    public SavedWorkId() {}

    public SavedWorkId(Integer userId, Integer workId) {
        this.userId = userId;
        this.workId = workId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavedWorkId)) return false;
        SavedWorkId that = (SavedWorkId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(workId, that.workId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, workId);
    }
}
