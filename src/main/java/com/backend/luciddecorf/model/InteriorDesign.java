package com.backend.luciddecorf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "interior_services")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InteriorDesign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "service_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceCategory serviceType;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "estimated_duration_hours")
    private Integer estimatedDurationHours;

    @Column(name = "difficulty_level")
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "requires_on_site_visit")
    private Boolean requiresOnSiteVisit = false;

    @ElementCollection
    @CollectionTable(name = "service_inclusions", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "inclusion")
    private List<String> inclusions = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "service_exclusions", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "exclusion")
    private List<String> exclusions = new ArrayList<>();

    @Column(name = "minimum_project_size")
    private String minimumProjectSize;

    @Column(name = "maximum_project_size")
    private String maximumProjectSize;

    // Metadata tracking
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Enums for categorization
    public enum ServiceCategory {
        RESIDENTIAL_DESIGN,
        COMMERCIAL_DESIGN,
        CONSULTATION,
        RENDERING,
        FURNITURE_SELECTION,
        PROJECT_MANAGEMENT,
        RENOVATION,
        STYLING,
        CUSTOM_DESIGN
    }

    public enum DifficultyLevel {
        BASIC,
        INTERMEDIATE,
        ADVANCED,
        COMPLEX,
        PREMIUM
    }

    // Subclass-specific methods can be added here
    public abstract double calculateFinalPrice();
}
