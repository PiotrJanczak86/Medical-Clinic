package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.CalendarEntryNotFoundException;
import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.CalendarEntry;
import com.crud.clinic.domain.dtos.CalendarEntryDto;
import com.crud.clinic.domain.dtos.DateDto;
import com.crud.clinic.mapper.CalendarEntryMapper;
import com.crud.clinic.service.CalendarEntryService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/calendar")
public class CalendarEntryController {
    private final CalendarEntryService calendarEntryService;
    private final CalendarEntryMapper calendarEntryMapper;


    @PostMapping(value = "/schedule", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSchedule(@RequestBody CalendarEntryDto calendarEntryDto) throws VisitNotFoundException {
        calendarEntryService.createSchedule(calendarEntryDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEntry(@RequestBody CalendarEntryDto calendarEntryDto) throws  VisitNotFoundException {
        calendarEntryService.saveEntry(calendarEntryMapper.mapToCalendarEntry(calendarEntryDto));
        return ResponseEntity.ok("entry created");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CalendarEntryDto> getEntry(@PathVariable Long id) throws CalendarEntryNotFoundException, VisitNotFoundException {
        return ResponseEntity.ok(calendarEntryMapper.mapToCalendarEntryDto(calendarEntryService.getEntry(id)));
    }

    @GetMapping
    public ResponseEntity<List<CalendarEntryDto>> getEntries() throws VisitNotFoundException {
        return ResponseEntity.ok(calendarEntryMapper.mapToCalendarEntryDtoList(calendarEntryService.getEntries()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEntry(@PathVariable Long id) throws CalendarEntryNotFoundException {
        calendarEntryService.deleteEntry(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping (value = "/availableDays/{doctorId}")
    public ResponseEntity<List<LocalDate>> checkAvailableDays(@PathVariable Long doctorId){
        return ResponseEntity.ok(calendarEntryService.checkForAvailableDays(doctorId));
    }

    @PostMapping(value = "/propose/")
    public ResponseEntity<Long> proposeEarliestHour(@RequestBody DateDto date) throws VisitNotFoundException {
        Long aaa = calendarEntryService.proposeEntry(date.getDate());
        System.out.println(aaa);
        return ResponseEntity.ok(aaa);
    }
}