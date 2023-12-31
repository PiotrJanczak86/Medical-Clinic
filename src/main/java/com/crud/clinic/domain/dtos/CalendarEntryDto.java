package com.crud.clinic.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
public class CalendarEntryDto {
    private Long id;
    private Long doctorId;
    private LocalDate date;
    private LocalTime from;
    private LocalTime until;
    private Long visitId;
}