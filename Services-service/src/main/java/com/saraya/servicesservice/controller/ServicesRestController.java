package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.ServicesDto;
import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("services")
public class ServicesRestController {
    private final ServicesService servicesService;

    @GetMapping
    public ResponseEntity<List<ServicesDto>> getAllServices() {
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServicesDto> getService(@PathVariable Long serviceId) {
        return ResponseEntity.ok(servicesService.getServicesByServiceId(serviceId));
    }

    @GetMapping("/service-name/{serviceName}")
    public ResponseEntity<ServicesDto> getServiceByName(@PathVariable String serviceName) {
        return ResponseEntity.ok(servicesService.getServicesByName(serviceName));
    }

    @PostMapping
    public ResponseEntity<Services> saveService(@RequestBody ServicesDto servicesDto) {
        return new ResponseEntity<>(servicesService.saveServices(servicesDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Services> updateService(@RequestBody ServicesDto servicesDto) {
        return ResponseEntity.ok(servicesService.updateService(servicesDto));
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<String> deleteService(@PathVariable Long serviceId) {
        servicesService.deleteService(serviceId);
        return ResponseEntity.ok("Service "+serviceId+" was deleted Successfully");
    }
}
