package com.saraya.servicesservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.saraya.servicesservice.model.Services} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServicesDto implements Serializable {
    private Long servicesId;
    private String servicesName;
    private String airportName;
}