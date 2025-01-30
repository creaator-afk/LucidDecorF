// ConsultationRepository.java
package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}