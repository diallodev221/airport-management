package com.saraya.servicesservice.proxies;

import com.saraya.servicesservice.bean.Airport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "airport-service", url = "http://localhost:8081/airports")
public interface AirportProxy {
    @GetMapping("/{airportName}")
    Airport getAirport(@PathVariable String airportName);

}
