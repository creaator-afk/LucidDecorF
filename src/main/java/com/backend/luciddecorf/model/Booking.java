// Booking.java
package com.backend.luciddecorf.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private InteriorDesign service;

    private LocalDateTime bookingTime;
    private String status;

    // Getters and setters
}