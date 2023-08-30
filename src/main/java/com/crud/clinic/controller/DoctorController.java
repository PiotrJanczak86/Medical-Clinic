package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.UserNotFoundException;
import com.crud.clinic.domain.Doctor;
import com.crud.clinic.domain.dtos.DoctorDto;
import com.crud.clinic.mapper.DoctorMapper;
import com.crud.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/doctors")
public class DoctorController {
private final DoctorService doctorService;
private final DoctorMapper doctorMapper;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDoctor(@RequestBody DoctorDto doctorDto) throws UserNotFoundException {
        doctorService.saveDoctor(doctorMapper.mapToDoctor(doctorDto));
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long userId) {
        return ResponseEntity.ok(doctorMapper.mapToDoctorDto(doctorService.getDoctor(userId)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id){
        return ResponseEntity.ok(doctorMapper.mapToDoctorDto(doctorService.getDoctorById(id)));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors(){
        return ResponseEntity.ok(doctorMapper.mapToDoctorDtoList(doctorService.getDoctors()));
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable Long id)throws DoctorNotFoundException {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) throws UserNotFoundException {
        Doctor doctor = doctorMapper.mapToDoctor(doctorDto);
        doctor.setId(id);
        doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(doctorDto);
    }
}