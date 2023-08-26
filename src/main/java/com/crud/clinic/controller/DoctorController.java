package com.crud.clinic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping(value = "/new/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDoctor() {
        return ResponseEntity.ok(new Object());
    }

    @GetMapping(value = "/{doctorId}")
    public ResponseEntity<Object> getDoctor() {
        return ResponseEntity.ok(new Object());
    }


    @DeleteMapping (value = "/{doctorId}")
    public ResponseEntity<Object> deleteDoctor() {
        return ResponseEntity.ok(new Object());
    }


    @PutMapping(value = "/{doctorId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateDoctor() {
        return ResponseEntity.ok(new Object());
    }

}