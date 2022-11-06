package com.saraya.Airport_Geoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirportGeoDto implements Serializable {
    private Long airportGeoId;
    private String country;
    private String city;
}