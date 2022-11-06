package com.saraya.Flightservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;

    private String flight_no;

    @Column(columnDefinition = "date")
    private LocalDate departure_date = LocalDate.now();

    @Column(columnDefinition = "date")
    private LocalDate arrival_date;

    private String from;
    private String to;
}
