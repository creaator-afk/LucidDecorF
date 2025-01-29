package com.backend.luciddecorf.controller;

    import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
    import com.backend.luciddecorf.model.InteriorService;
    import com.backend.luciddecorf.service.InteriorDesignService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/services")
    public class ServiceController {

        private final InteriorDesignService interiorDesignService;

        @Autowired
        public ServiceController(InteriorDesignService interiorDesignService) {
            this.interiorDesignService = interiorDesignService;
        }

        @PostMapping("/service")
        public ResponseEntity<InteriorService> addService(@RequestBody InteriorService interiorService) {
            InteriorService createdService = interiorDesignService.createService(interiorService);
            return new ResponseEntity<>(createdService, HttpStatus.CREATED);
        }

        @PutMapping("/service/{id}")
        public ResponseEntity<InteriorService> updateService(@PathVariable long id, @RequestBody InteriorService interiorService) throws ServiceNotFoundException {
            InteriorService updatedService = interiorDesignService.updateService(id, interiorService);
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        }

        @DeleteMapping("/service/{id}")
        public ResponseEntity<Void> deleteService(@PathVariable long id) throws ServiceNotFoundException {
            interiorDesignService.deleteService(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/service/{id}")
        public ResponseEntity<InteriorService> getService(@PathVariable long id) throws ServiceNotFoundException {
            InteriorService service = interiorDesignService.getServiceById(id);
            return new ResponseEntity<>(service, HttpStatus.OK);
        }

        @GetMapping("/")
        public ResponseEntity<List<InteriorService>> getAllServices() {
            List<InteriorService> services = interiorDesignService.getAllServices();
            return new ResponseEntity<>(services, HttpStatus.OK);
        }
    }