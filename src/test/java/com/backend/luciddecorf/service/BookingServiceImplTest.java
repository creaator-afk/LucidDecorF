package com.backend.luciddecorf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.backend.luciddecorf.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingServiceImplTest {

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Test
    void shouldReturnExpectedResult() {
        String result = bookingServiceImpl.getAllBookings().toString();
        assertEquals("expectedResult", result);
    }
}