package com.saraya.Airportservice.controller;

import com.saraya.Airportservice.dto.AirportDto;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airports")
@RestController
public class AirportRestController {

    private final AirportService service;

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        return ResponseEntity.ok(service.getAllAirports());
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportDto> getAirport(@PathVariable Long airportId) {
        return ResponseEntity.ok(service.getAirportByAirportId(airportId));
    }

    @GetMapping("/{airportName}")
    public ResponseEntity<AirportDto> getAirport(@PathVariable String airportName) {
        return ResponseEntity.ok(service.getAirportByAirportNam(airportName));
    }

    @PostMapping
    public ResponseEntity<Airport> saveAirport(@RequestBody AirportDto airportDto) {
        return new ResponseEntity<>(service.saveAirport(airportDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airport> updateAirport(@RequestBody AirportDto airportDto) {
        return new ResponseEntity<>(service.updateAirport(airportDto), HttpStatus.OK);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long airportId) {
        service.deleteAirport(airportId);
        return ResponseEntity.ok("Airport "+airportId+" was deleted");
    }



}
