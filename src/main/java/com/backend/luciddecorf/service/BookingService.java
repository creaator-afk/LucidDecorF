// BookingService.java
package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    void deleteBooking(Long id);
}