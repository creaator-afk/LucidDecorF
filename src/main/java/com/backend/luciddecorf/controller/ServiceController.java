package com.backend.luciddecorf.controller;

    import com.backend.luciddecorf.exceptions.ServiceNotFoundException;
    import com.backend.luciddecorf.model.InteriorDesign;
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
        public ResponseEntity<InteriorDesign> addService(@RequestBody InteriorDesign interiorDesign) {
            InteriorDesign createdService = interiorDesignService.createService(interiorDesign);
            return new ResponseEntity<>(createdService, HttpStatus.CREATED);
        }

        @GetMapping("/service/name")
        public ResponseEntity<List<InteriorDesign>> getServiceByName(@RequestParam String title) {
            List<InteriorDesign> services = interiorDesignService.getServiceByName(title);
            return new ResponseEntity<>(services, HttpStatus.OK);
        }

        @PutMapping("/service/{id}")
        public ResponseEntity<InteriorDesign> updateService(@PathVariable long id, @RequestBody InteriorDesign interiorDesign) throws ServiceNotFoundException {
            InteriorDesign updatedService = interiorDesignService.updateService(id, interiorDesign);
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        }

        @DeleteMapping("/service/{id}")
        public ResponseEntity<Void> deleteService(@PathVariable long id) throws ServiceNotFoundException {
            interiorDesignService.deleteService(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/service/{id}")
        public ResponseEntity<InteriorDesign> getService(@PathVariable long id) throws ServiceNotFoundException {
            InteriorDesign service = interiorDesignService.getServiceById(id);
            return new ResponseEntity<>(service, HttpStatus.OK);
        }

        @GetMapping("/")
        public ResponseEntity<List<InteriorDesign>> getAllServices() {
            List<InteriorDesign> services = interiorDesignService.getAllServices();
            return new ResponseEntity<>(services, HttpStatus.OK);
        }
    }