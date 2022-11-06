package com.saraya.Airportservice.proxies;

import com.saraya.Airportservice.bean.Airline;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(name = "airline-service", url = "http://localhost:8084/airlines")
public interface AirlineProxy {

    @GetMapping("/{airlineName}")
    Airline getAirlineByName(@PathVariable String airlineName);

}
