package com.saraya.Airportservice.proxies;

import com.saraya.Airportservice.bean.AirportGeo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "airport-geo-service", url = "http://localhost:8080/airports-geo")
public interface AirportGeoProxy {


    @GetMapping("/{country}/{city}")
    AirportGeo getAirportGeoByCountryAndCity(@PathVariable String country, @PathVariable String city);
}
