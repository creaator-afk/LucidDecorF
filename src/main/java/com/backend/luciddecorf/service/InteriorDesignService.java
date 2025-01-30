package com.backend.luciddecorf.service;

import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
import com.backend.luciddecorf.model.InteriorService;

import java.util.List;

public interface InteriorDesignService {
    List<InteriorService> getAllServices();
    InteriorService getServiceById(long id) throws ServiceNotFoundException;
    InteriorService createService(InteriorService interiorService);
    InteriorService updateService(long id, InteriorService interiorService) throws ServiceNotFoundException;
    void deleteService(long id) throws ServiceNotFoundException;
}