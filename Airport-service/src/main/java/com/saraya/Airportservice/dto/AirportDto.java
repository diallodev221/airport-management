package com.saraya.Airportservice.dto;

import lombok.Data;

@Data
public class AirportDto {
    private Long airportId;
    private String iata;
    private String icao;
    private String airportName;
    private String country;
    private String city;
    private String airlineName;
}
