package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.dtos.CalendarEntryDto;
import com.crud.clinic.mapper.CalendarEntryMapper;
import com.crud.clinic.repository.CalendarEntryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarEntryService {

    private final CalendarEntryRepository repository;
    private final CalendarEntryMapper calendarEntryMapper;


    public List<CalendarEntry> getEntries() {
        return repository.findAll();
    }

    public CalendarEntry getEntry(Long id) throws CalendarEntryNotFoundException {
        return repository.findById(id).orElseThrow(CalendarEntryNotFoundException::new);
    }


    public CalendarEntry saveEntry(CalendarEntry entry) {

        return repository.save(entry);
    }

    public void deleteEntry(Long id) throws CalendarEntryNotFoundException {
        CalendarEntry toBeDeletedEntry = repository.findById(id).orElseThrow(CalendarEntryNotFoundException::new);
        repository.delete(toBeDeletedEntry);
    }

    public void createSchedule(CalendarEntryDto calendarEntryDto) throws VisitNotFoundException {
        long n = calendarEntryDto.getFrom().until(calendarEntryDto.getUntil(), ChronoUnit.MINUTES) / 30;
        for (int i = 0; i <= n; i++) {
            LocalTime intervalFrom = calendarEntryDto.getFrom().plus(i * 30L, ChronoUnit.MINUTES);
            LocalTime intervalUntil = intervalFrom.plus(30, ChronoUnit.MINUTES);
            repository.save(calendarEntryMapper.mapToCalendarEntry(new CalendarEntryDto(1L, calendarEntryDto.getDoctorId(), calendarEntryDto.getDate(), intervalFrom, intervalUntil, null)));
        }
    }

    public List<LocalDate> checkForAvailableDays(Long doctorId){
        List<CalendarEntry> entries = repository.findAllByDoctor_Id(doctorId);
        return entries.stream()
                .map(CalendarEntry::getDate)
                .distinct()
                .toList();
    }

    public Long proposeEntry(LocalDate date) throws VisitNotFoundException {
        List<CalendarEntry> entries = repository.findCalendarEntriesByDate(date);
        for (CalendarEntry entry: entries){
            if(entry.getVisit() == (null)) return entry.getId();
        } return null;
    }
}