package com.saraya.Airport_Geoservice.controller;

import com.saraya.Airport_Geoservice.dto.AirportGeoDto;
import com.saraya.Airport_Geoservice.model.AirportGeo;
import com.saraya.Airport_Geoservice.service.AirportGeoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/airports-geo")
public class AirportGeoRestController {

    private final AirportGeoService service;

    @GetMapping
    public ResponseEntity<List<AirportGeoDto>> getAllAirportGeo() {
        return ResponseEntity.ok(service.getAllAirportGeo());
    }

    @GetMapping("/{airportGeoId}")
    public ResponseEntity<AirportGeoDto> getAirportGeo(@PathVariable Long airportGeoId) {
        return ResponseEntity.ok(service.getAirportGeo(airportGeoId));
    }

    @GetMapping("/{country}/{city}")
    public ResponseEntity<AirportGeoDto> getAirportGeoByCountryAndCity(
            @PathVariable String country, @PathVariable String city) {
        return ResponseEntity.ok(service.getAirportGeo(country, city));
    }

    @PostMapping
    public ResponseEntity<AirportGeo> saveAirportGeo(@RequestBody AirportGeoDto airportGeoDto) {
        return new ResponseEntity<>(service.saveAirportGeo(airportGeoDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AirportGeo> updateAirportGeo(@RequestBody AirportGeoDto airportGeoDto) {
        return ResponseEntity.ok(service.updateAirportGeo(airportGeoDto));
    }

    @DeleteMapping("/{airportGeoId}")
    public ResponseEntity<String> deleteAirportGeo(@PathVariable Long airportGeoId) {
        service.deleteAirportGeo(airportGeoId);
        return ResponseEntity.ok("Airport_Geo "+airportGeoId+" has been deleted");
    }

}
