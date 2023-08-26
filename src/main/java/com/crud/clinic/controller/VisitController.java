package com.crud.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/visits")
public class VisitController {

    @PostMapping(value = "/new/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVisit() {
        return ResponseEntity.ok(new Object());
    }

    @GetMapping(value = "/{visitId}")
    public ResponseEntity<Object> getVisit() {
        return ResponseEntity.ok(new Object());
    }


    @DeleteMapping (value = "/{visitId}")
    public ResponseEntity<Object> deleteVisit() {
        return ResponseEntity.ok(new Object());
    }


    @PutMapping(value = "/{visitId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateVisit() {
        return ResponseEntity.ok(new Object());
    }

}