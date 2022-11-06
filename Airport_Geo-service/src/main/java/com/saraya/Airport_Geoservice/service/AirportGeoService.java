package com.saraya.Airport_Geoservice.service;

import com.saraya.Airport_Geoservice.dto.AirportGeoDto;
import com.saraya.Airport_Geoservice.model.AirportGeo;
import com.saraya.Airport_Geoservice.repository.AirportGeoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class AirportGeoService {

    private final AirportGeoRepository repository;
    private final ModelMapper mapper;

    public List<AirportGeoDto> getAllAirportGeo() {
        return repository.findAll().stream()
                .map(airportGeo -> mapper.map(airportGeo, AirportGeoDto.class)).toList();
    }

    public AirportGeoDto getAirportGeo(Long airportGeoId) {
        log.info("Get Airport Geo {}", airportGeoId);
        AirportGeo airportGeo = repository.findById(airportGeoId)
                .orElseThrow(() -> new IllegalArgumentException("Airport Geo id " + airportGeoId + " not found"));
        return mapper.map(airportGeo, AirportGeoDto.class);
    }

    public AirportGeo saveAirportGeo(AirportGeoDto airportGeoDto) {
        log.info("New Airport Geo has been added: {}", airportGeoDto);
        return repository.save(mapper.map(airportGeoDto, AirportGeo.class));
    }

    public AirportGeo updateAirportGeo(AirportGeoDto airportGeoDto) {
        log.info("Airport Geo {} has been updated: {}",airportGeoDto.getAirportGeoId(), airportGeoDto);
        return repository.save(mapper.map(airportGeoDto, AirportGeo.class));
    }

    public void deleteAirportGeo(Long airportGeoId) {
        log.info("Airport Geo {} has been deleted", airportGeoId);
        repository.deleteById(airportGeoId);
    }

    public AirportGeoDto getAirportGeo(String country, String city) {
        AirportGeo airportGeo = repository.findAirportGeoByCountryAndCity(country, city);
        return mapper.map(airportGeo, AirportGeoDto.class);
    }
}
