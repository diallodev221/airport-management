package com.saraya.Flightservice.controller;

import com.saraya.Flightservice.dto.FlightDto;
import com.saraya.Flightservice.model.Flight;
import com.saraya.Flightservice.service.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("flights")
public class FlightRestController {

    private final FlightServiceImpl flightService;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFights() {
        return ResponseEntity.ok(flightService.getAllFights());
    }

    @GetMapping("/{flight_id}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable Long flight_id) {
        return ResponseEntity.ok(flightService.getFlight(flight_id));
    }

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@RequestBody FlightDto dto) {
        return new ResponseEntity<>(flightService.saveFlight(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDto dto) {
        return ResponseEntity.ok(flightService.updateFlight(dto));
    }

    @DeleteMapping("/{flight_id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flight_id) {
        flightService.deleteFlight(flight_id);
        return ResponseEntity.ok("Flight "+flight_id+" was deleted successfully");
    }
}
