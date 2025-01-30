package com.backend.luciddecorf.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime consultationTime;
    private String notes;

    // Getters and setters
}