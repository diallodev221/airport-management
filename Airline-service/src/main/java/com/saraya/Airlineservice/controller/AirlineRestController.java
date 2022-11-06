package com.saraya.Airlineservice.controller;

import com.saraya.Airlineservice.dto.AirlineDto;
import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airlines")
@RestController
public class AirlineRestController {

    private final AirlineService service;

    @GetMapping
    public ResponseEntity<List<AirlineDto>> getAllAirlines() {
        return ResponseEntity.ok(service.getAllAirlines());
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> getAirline(@PathVariable Long airlineId) {
        return ResponseEntity.ok(service.getAirlineByAirlineId(airlineId));
    }

    @PostMapping
    public ResponseEntity<Airline> saveAirline(@RequestBody AirlineDto airlineDto) {
        return new ResponseEntity<>(service.saveAirline(airlineDto), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Airline> updateAirline(@RequestBody AirlineDto airlineDto) {
        return ResponseEntity.ok(service.updateAirline(airlineDto));
    }

    @DeleteMapping("/{airlineId}")
    public ResponseEntity<String> deleteAirline(@PathVariable Long airlineId) {
        service.deleteAirline(airlineId);
        return ResponseEntity.ok("Airline "+airlineId+" was deleted successfully");
    }

    @GetMapping("/airline-name/{name}")
    public ResponseEntity<AirlineDto> getAirlineByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getAirlineByName(name));
    }


}
