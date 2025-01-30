// BookingRepository.java
package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}