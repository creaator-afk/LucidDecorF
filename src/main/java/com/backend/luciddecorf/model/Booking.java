// Booking.java
package com.backend.luciddecorf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

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