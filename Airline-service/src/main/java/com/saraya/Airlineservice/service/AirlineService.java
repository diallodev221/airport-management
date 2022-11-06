package com.saraya.Airlineservice.service;

import com.saraya.Airlineservice.bean.Airplane;
import com.saraya.Airlineservice.dto.AirlineDto;
import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.proxies.AirplaneProxy;
import com.saraya.Airlineservice.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirlineService {

    private final AirlineRepository repository;
    private final ModelMapper mapper;

    private final AirplaneProxy airplaneProxy;


    public List<AirlineDto> getAllAirlines() {
        return repository.findAll().stream()
                .map(airline -> mapper.map(airline, AirlineDto.class)).toList();
    }

    public AirlineDto getAirlineByAirlineId(Long airlineId) {
        Airline airline = repository.findById(airlineId)
                .orElseThrow(() -> new IllegalArgumentException("Airline id " + airlineId + " not found"));
        return mapper.map(airline, AirlineDto.class);


    }public AirlineDto getAirlineByName(String airlineName) {
        Airline airline = repository.getAirlineByAirlineName(airlineName);
        return mapper.map(airline, AirlineDto.class);
    }

    public Airline saveAirline(AirlineDto airlineDto) {
        Airline airline = getAirline(airlineDto);
        return repository.save(airline);
    }

    public Airline updateAirline(AirlineDto airlineDto) {
        Airline airline = getAirline(airlineDto);
        return repository.save(airline);
    }

    public void deleteAirline(Long airlineId) {
        repository.deleteById(airlineId);
    }


    private Airline getAirline(AirlineDto airlineDto) {
        Airline airline = mapper.map(airlineDto, Airline.class);
        Airplane airplane = airplaneProxy.getAirplane(airlineDto.getAirplaneId());
        airline.setAirplaneId(airplane.getAirplaneId());
        return airline;
    }
}
