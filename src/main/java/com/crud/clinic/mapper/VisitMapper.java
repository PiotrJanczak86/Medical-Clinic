package com.crud.clinic.mapper;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.PatientNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.Patient;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.VisitDto;
import com.crud.clinic.service.CalendarEntryService;
import com.crud.clinic.service.DoctorService;
import com.crud.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitMapper {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private CalendarEntryService calendarEntryService;

    public VisitDto mapToVisitDto(final Visit visit){
        List<Long> entriesIds = visit.getCalendarEntriesList().stream()
                .map(CalendarEntry::getId)
                .toList();
        return new VisitDto(visit.getPatient().getId(), visit.getDoctor().getId(), visit.getDescription(), entriesIds);
    }

    public Visit mapToVisit(final VisitDto visitDto) throws PatientNotFoundException, DoctorNotFoundException {
        List<CalendarEntry> entries = visitDto.getEntriesId().stream()
                .map(c -> {
                    try {
                        return calendarEntryService.getEntry(c);
                    } catch (CalendarEntryNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
        Patient patient = patientService.getPatient(visitDto.getPatientId());
        Doctor doctor = doctorService.getDoctor(visitDto.getDoctorId());
        return new Visit(null, patient, doctor, visitDto.getDescription(), entries);
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visits){
        return visits.stream()
                .map(this::mapToVisitDto)
                .toList();
    }
}