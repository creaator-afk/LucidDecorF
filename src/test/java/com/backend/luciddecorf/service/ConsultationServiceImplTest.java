package com.backend.luciddecorf.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.backend.luciddecorf.service.impl.BookingServiceImpl;
import com.backend.luciddecorf.service.impl.ConsultationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@WebMvcTest(ConsultationServiceImpl.class)
class ConsultationServiceImplTest {

    @Autowired
    private ConsultationServiceImpl consultationServiceImpl;

    @Test
    void shouldReturnExpectedResult() {
        String result = consultationServiceImpl.getAllConsultations().toString();
        assertEquals("expectedResult", result);
    }
}