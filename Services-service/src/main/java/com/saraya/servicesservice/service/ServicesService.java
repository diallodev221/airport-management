package com.saraya.servicesservice.service;

import com.saraya.servicesservice.ServicesDto;
import com.saraya.servicesservice.bean.Airport;
import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.proxies.AirportProxy;
import com.saraya.servicesservice.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicesService {

    private final ServicesRepository repository;
    private final AirportProxy airportProxy;
    private final ModelMapper mapper;

    public List<ServicesDto> getAllServices() {
        return repository.findAll()
                .stream().map(services -> mapper.map(services, ServicesDto.class)).toList();
    }

    public ServicesDto getServicesByServiceId(Long serviceId) {
        Services services = repository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service id " + serviceId + " not found"));
        return mapper.map(services, ServicesDto.class);
    }

    public ServicesDto getServicesByName(String serviceName) {
        Services service = repository.getServiceByServicesName(serviceName);
        return mapper.map(service, ServicesDto.class);
    }

    public Services saveServices(ServicesDto servicesDto) {
        Services services = getServices(servicesDto);
        return repository.save(services);
    }

    public Services updateService(ServicesDto servicesDto) {
        Services services = getServices(servicesDto);
        return repository.save(services);
    }

    public void deleteService(Long serviceId) {
        repository.deleteById(serviceId);
    }

    private Services getServices(ServicesDto service) {
        Services services = mapper.map(service, Services.class);
        Airport airport = airportProxy.getAirport(service.getAirportName());
        services.setAirportId(airport.getAirportId());
        return services;
    }

}
