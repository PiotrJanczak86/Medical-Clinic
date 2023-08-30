package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.PatientNotFoundException;
import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.Patient;
import com.crud.clinic.domain.dtos.PatientDto;
import com.crud.clinic.mapper.PatientMapper;
import com.crud.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createPatient(@RequestBody PatientDto patientDto) throws UserNotFoundException {
        patientService.savePatient(patientMapper.mapToPatient(patientDto));
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Object> getPatient(@PathVariable Long userId) {
        return ResponseEntity.ok(patientMapper.mapToPatientDto(patientService.getPatient(userId)));
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getPatients(){
        return ResponseEntity.ok(patientMapper.mapToPatientDtoList(patientService.getPatients()));
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) throws PatientNotFoundException {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) throws UserNotFoundException {
        Patient patient = patientMapper.mapToPatient(patientDto);
        patient.setId(id);
        return ResponseEntity.ok(patientDto);
    }
}