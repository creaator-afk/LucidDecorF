package com.backend.luciddecorf.model;

import com.backend.luciddecorf.repositories.InteriorServiceRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interior_services")
public class InteriorService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private double price;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "service_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private InteriorServiceRepository.ServiceCategory serviceType;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "estimated_duration_hours")
    private Integer estimatedDurationHours;

    @Column(name = "difficulty_level")
    @Enumerated(EnumType.STRING)
    private InteriorServiceRepository.DifficultyLevel difficultyLevel;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "requires_on_site_visit")
    private Boolean requiresOnSiteVisit = false;

    @ElementCollection
    @CollectionTable(name = "service_inclusions", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "inclusion")
    private List<String> inclusions;

    @ElementCollection
    @CollectionTable(name = "service_exclusions", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "exclusion")
    private List<String> exclusions;

    @Column(name = "minimum_project_size")
    private String minimumProjectSize;

    @Column(name = "maximum_project_size")
    private String maximumProjectSize;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public double calculateFinalPrice() {
        // Implement the logic to calculate the final price
        return basePrice.doubleValue();
    }
}