package com.saraya.Flightservice.service;


import com.saraya.Flightservice.dto.FlightDto;
import com.saraya.Flightservice.model.Flight;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFights();

    FlightDto getFlight(Long flight_id);

    Flight saveFlight(FlightDto dto);

    Flight updateFlight(FlightDto dto);

    void deleteFlight(Long flight_id);
}
