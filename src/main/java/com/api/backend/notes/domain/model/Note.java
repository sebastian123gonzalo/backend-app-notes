package com.api.backend.notes.domain.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private boolean archived = false;
}
