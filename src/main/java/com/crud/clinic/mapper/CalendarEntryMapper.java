package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.CalendarEntryDto;
import com.crud.clinic.service.DoctorService;
import com.crud.clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEntryMapper {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private VisitService visitService;

    public CalendarEntryDto mapToCalendarEntryDto(final CalendarEntry calendarEntry){
        return new CalendarEntryDto(calendarEntry.getDoctor().getId(), calendarEntry.getDate(), calendarEntry.getFrom(), calendarEntry.getUntil(), calendarEntry.getVisit().getId());
    }

    public CalendarEntry mapToCalendarEntry(final CalendarEntryDto calendarEntryDto) throws DoctorNotFoundException, VisitNotFoundException {
        Visit visit = visitService.getVisit(calendarEntryDto.getVisitId());
        Doctor doctor = doctorService.getDoctor(calendarEntryDto.getDoctorId());
        return new CalendarEntry(null, doctor, calendarEntryDto.getDate(), calendarEntryDto.getFrom(), calendarEntryDto.getUntil(), visit);
    }

    public List<CalendarEntryDto> mapToCalendarEntryDtoList(final List<CalendarEntry> calendarEntries){
        return calendarEntries.stream()
                .map(this::mapToCalendarEntryDto)
                .toList();
    }
}
