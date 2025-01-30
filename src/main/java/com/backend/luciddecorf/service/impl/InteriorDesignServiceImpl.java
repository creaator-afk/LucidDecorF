package com.backend.luciddecorf.service.impl;

import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
import com.backend.luciddecorf.model.InteriorService;
import com.backend.luciddecorf.repositories.ServiceRepository;
import com.backend.luciddecorf.service.InteriorDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteriorDesignServiceImpl implements InteriorDesignService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public InteriorDesignServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<InteriorService> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public InteriorService getServiceById(long id) throws ServiceNotFoundException {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found with id: " + id));
    }

    @Override
    public InteriorService createService(InteriorService interiorService) {
        return serviceRepository.save(interiorService);
    }

    @Override
    public InteriorService updateService(long id, InteriorService interiorService) throws ServiceNotFoundException {
        InteriorService existingInteriorService = getServiceById(id);
        existingInteriorService.setTitle(interiorService.getTitle());
        existingInteriorService.setDescription(interiorService.getDescription());
        existingInteriorService.setBasePrice(interiorService.getBasePrice());
        return serviceRepository.save(existingInteriorService);
    }

    @Override
    public void deleteService(long id) throws ServiceNotFoundException {
        InteriorService existingInteriorService = getServiceById(id);
        serviceRepository.delete(existingInteriorService);
    }
}