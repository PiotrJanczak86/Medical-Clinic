package com.crud.clinic.service;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.repository.CalendarEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarEntryService {

    private final CalendarEntryRepository repository;

    public List<CalendarEntry> getEntries(){return repository.findAll();}

    public CalendarEntry getEntry(Long id) throws CalendarEntryNotFoundException {
        return repository.findById(id).orElseThrow(CalendarEntryNotFoundException::new);
    }

    public CalendarEntry saveEntry(CalendarEntry entry) {return repository.save(entry);}

    public void deleteEntry(Long id) throws CalendarEntryNotFoundException{
        CalendarEntry toBeDeletedEntry = repository.findById(id).orElseThrow(CalendarEntryNotFoundException::new);
        repository.delete(toBeDeletedEntry);
    }

}