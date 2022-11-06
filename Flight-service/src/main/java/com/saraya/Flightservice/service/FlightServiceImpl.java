package com.saraya.Flightservice.service;

import com.saraya.Flightservice.dto.FlightDto;
import com.saraya.Flightservice.model.Flight;
import com.saraya.Flightservice.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository flightRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<FlightDto> getAllFights() {
        return flightRepository.findAll().stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class)).toList();
    }

    @Override
    public FlightDto getFlight(Long flight_id) {
        Flight flight = flightRepository.findById(flight_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Flight Id: "+flight_id));
        return modelMapper.map(flight, FlightDto.class);
    }


    @Override
    public Flight saveFlight(FlightDto dto) {
        return modelMapper.map(dto, Flight.class);
    }

    @Override
    public Flight updateFlight(FlightDto dto) {
        return modelMapper.map(dto, Flight.class);
    }

    @Override
    public void deleteFlight(Long flight_id) {
        flightRepository.deleteById(flight_id);
    }
}
