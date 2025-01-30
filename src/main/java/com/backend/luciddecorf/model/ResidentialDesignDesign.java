package com.backend.luciddecorf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

// Example of a concrete implementation
@Entity
@Table(name = "residential_design_services")
public class ResidentialDesignDesign extends InteriorDesign {
    @Column(name = "room_type")
    private String roomType;

    @Column(name = "design_style")
    private String designStyle;

    @Override
    public double calculateFinalPrice() {
        // Custom pricing logic based on room type, style, etc.
        return getBasePrice().doubleValue() * (roomType != null ? 1.2 : 1.0);
    }

    public BigDecimal getBasePrice() {
        
        return null;
    }
}
