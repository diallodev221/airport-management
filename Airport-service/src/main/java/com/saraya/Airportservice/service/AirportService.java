package com.saraya.Airportservice.service;


import com.saraya.Airportservice.bean.Airline;
import com.saraya.Airportservice.bean.AirportGeo;
import com.saraya.Airportservice.dto.*;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.proxies.AirlineProxy;
import com.saraya.Airportservice.proxies.AirportGeoProxy;
import com.saraya.Airportservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class AirportService {

    private final AirportRepository repository;
    private final AirlineProxy airlineProxy;
    private final AirportGeoProxy airportGeoProxy;
    private final ModelMapper mapper;


    public List<AirportDto> getAllAirports() {
        return repository.findAll().stream()
                .map(airport -> mapper.map(airport, AirportDto.class)).toList();
    }

    public AirportDto getAirportByAirportId(Long airportId) {
        Airport airport = repository.findById(airportId)
                .orElseThrow(() -> new IllegalArgumentException("Airport Geo not found"));
        return mapper.map(airport, AirportDto.class) ;
    }

    public AirportDto getAirportByAirportNam(String airportName) {
        Airport airport = repository.findByAirportName(airportName);
        return mapper.map(airport, AirportDto.class);
    }

    public Airport saveAirport(AirportDto dto) {
        Airport airport = getAirport(dto);
        return repository.save(airport);
    }




    public Airport updateAirport(AirportDto dto) {
        Airport airport = getAirport(dto);
        return repository.save(airport);
    }

    public void deleteAirport(Long airportId) {
        repository.deleteById(airportId);
    }


    private Airport getAirport(AirportDto dto) {
        Airport airport = mapper.map(dto, Airport.class);
        Airline airline = airlineProxy.getAirlineByName(dto.getAirlineName());
        AirportGeo airportGeo = airportGeoProxy.getAirportGeoByCountryAndCity(dto.getCountry(), dto.getCity());
        airport.setAirportGeoId(airportGeo.getAirportGeoId());
        airport.setAirlineId(airline.getAirlineId());
        return airport;
    }
}
