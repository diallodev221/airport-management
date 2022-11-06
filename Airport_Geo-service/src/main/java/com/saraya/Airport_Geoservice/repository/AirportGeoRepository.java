package com.saraya.Airport_Geoservice.repository;

import com.saraya.Airport_Geoservice.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo, Long> {

    AirportGeo findAirportGeoByCountryAndCity(String country, String city);

}
