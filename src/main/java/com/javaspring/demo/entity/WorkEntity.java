package com.javaspring.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "works")
public class WorkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Змінено на Long

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author; // Зв'язок з UserEntity
}
