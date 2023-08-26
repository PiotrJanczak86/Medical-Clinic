package com.crud.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping(value = "/new/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPatient() {
        return ResponseEntity.ok(new Object());
    }

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<Object> getPatient() {
        return ResponseEntity.ok(new Object());
    }


    @DeleteMapping (value = "/{patientId}")
    public ResponseEntity<Object> deletePatient() {
        return ResponseEntity.ok(new Object());
    }


    @PutMapping(value = "/{patientId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePatient() {
        return ResponseEntity.ok(new Object());
    }

}