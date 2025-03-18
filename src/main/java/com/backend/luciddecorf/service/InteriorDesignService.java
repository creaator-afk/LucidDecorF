package com.backend.luciddecorf.service;

import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
import com.backend.luciddecorf.model.InteriorDesign;

import java.util.List;

public interface InteriorDesignService {
    List <InteriorDesign> getServiceByParams(String title, String basePriceMax, String basePriceMin, String requiresOnsiteVisit, String minimumProjectScale, String maximumProjectScale);
    List<InteriorDesign> getAllServices();
    InteriorDesign getServiceById(long id) throws ServiceNotFoundException;
    InteriorDesign createService(InteriorDesign interiorDesign);
    InteriorDesign updateService(long id, InteriorDesign interiorDesign) throws ServiceNotFoundException;
    void deleteService(long id) throws ServiceNotFoundException;
}