package com.saraya.Airlineservice.repository;

import com.saraya.Airlineservice.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    @Query("select a from Airline a where a.airlineName = ?1")
    Airline getAirlineByAirlineName(String airlineName);

}
