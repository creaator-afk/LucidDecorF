// ConsultationService.java
package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.Consultation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {
    Consultation createConsultation(Consultation consultation);
    Consultation getConsultationById(Long id);
    List<Consultation> getAllConsultations();
    void deleteConsultation(Long id);
}