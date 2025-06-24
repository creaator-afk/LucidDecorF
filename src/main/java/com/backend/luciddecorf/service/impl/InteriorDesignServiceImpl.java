package com.backend.luciddecorf.service.impl;

    import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
    import com.backend.luciddecorf.model.InteriorDesign;
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
        public List<InteriorDesign> getAllServices() {
            return serviceRepository.findAll();
        }

        @Override
        public List<InteriorDesign> getServiceByParams(String title, String basePriceMax, String basePriceMin, String requiresOnsiteVisit, String minimumProjectScale, String maximumProjectScale) {
            return serviceRepository.findByParams(title, basePriceMax, basePriceMin, requiresOnsiteVisit, minimumProjectScale, maximumProjectScale);
        }

        @Override
        public InteriorDesign getServiceById(long id) throws ServiceNotFoundException {
            return serviceRepository.findById(id)
                    .orElseThrow(() -> new ServiceNotFoundException("Service not found with id: " + id));
        }

        @Override
        public InteriorDesign createService(InteriorDesign interiorDesign) {
            return serviceRepository.save(interiorDesign);
        }

        @Override
        public InteriorDesign updateService(long id, InteriorDesign interiorDesign) throws ServiceNotFoundException {
            InteriorDesign existingInteriorDesign = getServiceById(id);
            existingInteriorDesign.setTitle(interiorDesign.getTitle());
            existingInteriorDesign.setDescription(interiorDesign.getDescription());
            existingInteriorDesign.setBasePrice(interiorDesign.getBasePrice());
            return serviceRepository.save(existingInteriorDesign);
        }

        @Override
        public void deleteService(long id) throws ServiceNotFoundException {
            InteriorDesign existingInteriorDesign = getServiceById(id);
            serviceRepository.delete(existingInteriorDesign);
        }
    }