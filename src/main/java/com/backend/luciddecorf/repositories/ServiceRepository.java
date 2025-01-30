package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.InteriorDesign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.math.BigDecimal;
import java.util.List;

// Repository with enhanced methods
@Repository
public interface ServiceRepository extends JpaRepository<InteriorDesign, Long> {
    // Existing methods
    InteriorDesign save(InteriorDesign service);
    InteriorDesign findByTitle(String title);
    InteriorDesign findByDescription(String description);

    // New query methods
    List<InteriorDesign> findByServiceType(InteriorDesign.ServiceCategory serviceType);
    List<InteriorDesign> findByDifficultyLevel(InteriorDesign.DifficultyLevel difficultyLevel);
    List<InteriorDesign> findByBasePriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<InteriorDesign> findByIsActiveTrue();

    @Query("SELECT s FROM InteriorDesign s WHERE s.estimatedDurationHours <= :maxHours")
    default List<InteriorDesign> findServicesByMaxDuration(@Param("maxHours") Integer maxHours) {
        return null;
    }

    List<InteriorDesign> findByTitleContainsIgnoreCase(String title);
}
