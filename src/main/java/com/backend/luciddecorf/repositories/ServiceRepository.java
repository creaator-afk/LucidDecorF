package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.InteriorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.math.BigDecimal;
import java.util.List;

// Repository with enhanced methods
@Repository
public interface ServiceRepository extends JpaRepository<InteriorService, Long> {
    // Existing methods
    InteriorServiceRepository save(InteriorServiceRepository service);
    InteriorServiceRepository findByTitle(String title);
    InteriorServiceRepository findByDescription(String description);

    // New query methods
    List<InteriorService> findByServiceType(InteriorServiceRepository.ServiceCategory serviceType);
    List<InteriorService> findByDifficultyLevel(InteriorServiceRepository.DifficultyLevel difficultyLevel);
    List<InteriorService> findByBasePriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<InteriorService> findByIsActiveTrue();

    @Query("SELECT s FROM InteriorServiceRepository s WHERE s.estimatedDurationHours <= :maxHours")
    default List<InteriorServiceRepository> findServicesByMaxDuration(@Param("maxHours") Integer maxHours) {
        return null;
    }
}
