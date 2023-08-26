package com.crud.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/calendar")
public class CalendarEntryController {

    @PostMapping(value = "/new/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEntry() {
        return ResponseEntity.ok(new Object());
    }

    @GetMapping(value = "/{entryId}")
    public ResponseEntity<Object> getEntry() {
        return ResponseEntity.ok(new Object());
    }


    @DeleteMapping (value = "/{entryId}")
    public ResponseEntity<Object> deleteEntry() {
        return ResponseEntity.ok(new Object());
    }


    @PutMapping(value = "/{entryId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEntry() {
        return ResponseEntity.ok(new Object());
    }

}