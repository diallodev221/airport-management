package com.saraya.servicesservice.bean;

import lombok.Data;

@Data
public class Airport {
    private Long airportId;
    private String iata;
    private String icao;
    private String airportName;
}
