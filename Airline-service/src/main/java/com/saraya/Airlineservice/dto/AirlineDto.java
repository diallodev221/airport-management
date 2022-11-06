package com.saraya.Airlineservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AirlineDto implements Serializable {
    private Long airlineId;
    private String airlineName;
    private String iata;
    private Long airplaneId;
}