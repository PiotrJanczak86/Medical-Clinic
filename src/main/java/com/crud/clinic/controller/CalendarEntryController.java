package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.dtos.CalendarEntryDto;
import com.crud.clinic.mapper.CalendarEntryMapper;
import com.crud.clinic.service.CalendarEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/calendar")
public class CalendarEntryController {
private final CalendarEntryService calendarEntryService;
private final CalendarEntryMapper calendarEntryMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEntry(@RequestBody CalendarEntryDto calendarEntryDto) throws DoctorNotFoundException, VisitNotFoundException {
        calendarEntryService.saveEntry(calendarEntryMapper.mapToCalendarEntry(calendarEntryDto));
        return ResponseEntity.ok("entry created");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CalendarEntryDto> getEntry(@PathVariable Long id)throws CalendarEntryNotFoundException {
        return ResponseEntity.ok(calendarEntryMapper.mapToCalendarEntryDto(calendarEntryService.getEntry(id)));
    }

    @GetMapping
    public ResponseEntity<List<CalendarEntryDto>> getEntries(){
    return ResponseEntity.ok(calendarEntryMapper.mapToCalendarEntryDtoList(calendarEntryService.getEntries()));
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Object> deleteEntry(@PathVariable Long id)throws CalendarEntryNotFoundException {
        calendarEntryService.deleteEntry(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalendarEntryDto> updateEntry(@PathVariable Long id, @RequestBody CalendarEntryDto calendarEntryDto) throws DoctorNotFoundException, VisitNotFoundException {
        CalendarEntry calendarEntry = calendarEntryMapper.mapToCalendarEntry(calendarEntryDto);
        calendarEntry.setId(id);
        calendarEntryService.saveEntry(calendarEntry);
        return ResponseEntity.ok(calendarEntryDto);
    }

}