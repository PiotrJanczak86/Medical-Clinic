package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.CalendarEntryDto;
import com.crud.clinic.service.DoctorService;
import com.crud.clinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEntryMapper {

    private final DoctorService doctorService;

    private final VisitService visitService;

    public CalendarEntryMapper(DoctorService doctorService, VisitService visitService) throws VisitNotFoundException {
        this.doctorService = doctorService;
        this.visitService = visitService;
    }


    public CalendarEntryDto mapToCalendarEntryDto(final CalendarEntry calendarEntry) throws VisitNotFoundException {
        Visit visit = null;
        if (calendarEntry.getVisit() != null) visit = visitService.getVisit(calendarEntry.getVisit().getId());

        return new CalendarEntryDto(calendarEntry.getId(), calendarEntry.getId(), calendarEntry.getDate(), calendarEntry.getFrom(), calendarEntry.getUntil(), null);
    }

    public CalendarEntry mapToCalendarEntry(final CalendarEntryDto calendarEntryDto) throws VisitNotFoundException {
        Visit visit = null;
        if (calendarEntryDto.getVisitId() != null) visit = visitService.getVisit(calendarEntryDto.getVisitId());

        Doctor doctor = doctorService.getDoctorById(calendarEntryDto.getDoctorId());
        return new CalendarEntry(1L, doctor, calendarEntryDto.getDate(), calendarEntryDto.getFrom(), calendarEntryDto.getUntil(), visit);
    }

    public List<CalendarEntryDto> mapToCalendarEntryDtoList(final List<CalendarEntry> calendarEntries) throws VisitNotFoundException {
        return calendarEntries.stream()
                .map(c -> {
                    try {
                       return mapToCalendarEntryDto(c);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    } return null;
                })
                .toList();
    }
}