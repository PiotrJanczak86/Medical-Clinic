package com.crud.clinic.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="CALENDAR")
public class CalendarEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    @NotNull
    private Doctor doctor;

    @Column(name = "'DATE'")
    @NotNull
    private LocalDate date;

    @Column(name = "'FROM'")
    @NotNull
    private LocalTime from;

    @Column(name = "'UNTIL'")
    @NotNull
    private LocalTime until;

    @ManyToOne
    @JoinColumn(name = "VISIT_ID")
    private Visit visit;
}