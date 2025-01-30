// ConsultationService.java
package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation createConsultation(Consultation consultation);
    Consultation getConsultationById(Long id);
    List<Consultation> getAllConsultations();
    void deleteConsultation(Long id);
}