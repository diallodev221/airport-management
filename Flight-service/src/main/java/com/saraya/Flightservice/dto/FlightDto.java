package com.saraya.Flightservice.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class FlightDto implements Serializable {
    private Long flight_id;
    private String flight_no;
    private String departure_date;
    private String arrival_date;
    private String from;
    private String to;
}