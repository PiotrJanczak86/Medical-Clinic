package com.crud.clinic.domain.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendarEntryDto {
    private Long doctorId;
    private LocalDate date;
    private LocalTime from;
    private LocalTime until;
    private Long visitId;
}