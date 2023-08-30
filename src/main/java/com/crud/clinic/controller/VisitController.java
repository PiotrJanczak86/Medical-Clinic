package com.crud.clinic.controller;

import com.crud.clinic.controller.exceptions.DoctorNotFoundException;
import com.crud.clinic.controller.exceptions.PatientNotFoundException;
import com.crud.clinic.controller.exceptions.VisitNotFoundException;
import com.crud.clinic.domain.Visit;
import com.crud.clinic.domain.dtos.VisitDto;
import com.crud.clinic.mapper.VisitMapper;
import com.crud.clinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/visits")
public class VisitController {
private final VisitService visitService;
private final VisitMapper visitMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVisit(@RequestBody VisitDto visitDto) throws DoctorNotFoundException, PatientNotFoundException {
        visitService.saveVisit(visitMapper.mapToVisit(visitDto));
        return ResponseEntity.ok("Visit created");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VisitDto> getVisit(@PathVariable Long id) throws VisitNotFoundException {
        return ResponseEntity.ok(visitMapper.mapToVisitDto(visitService.getVisit(id)));
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> getVisits(){
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(visitService.getVisits()));
    }

    @GetMapping(value = "/doctor/{userId}")
    public ResponseEntity<List<VisitDto>> getVisitsByDoctor(@PathVariable Long userId){
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(visitService.findVisitsByUserId(userId)));
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Object> deleteVisit(@PathVariable Long id)throws VisitNotFoundException {
        visitService.deleteVisit(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VisitDto> updateVisit(@PathVariable Long id, @RequestBody VisitDto visitDto) throws DoctorNotFoundException, PatientNotFoundException {
        Visit visit = visitMapper.mapToVisit(visitDto);
        visit.setId(id);
        visitService.saveVisit(visit);
        return ResponseEntity.ok(visitDto);
    }
}