package com.javaspring.demo.dto;

import lombok.Data;

@Data
public class WorkDTO {
    private String title;
    private String content;
    private String genre;
    private Integer authorId; // ID автора
}
