package com.crud.clinic.controller;

import com.crud.clinic.client.AcuWeatherClient;
import com.crud.clinic.client.CovidClient;
import com.crud.clinic.domain.dtos.AcuWeatherDto;
import com.crud.clinic.domain.dtos.CovidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/external")
public class ExternalApiController {
    private final AcuWeatherClient acuWeatherClient;
    private final CovidClient covidClient;

    @GetMapping(value = "/allergy")
    public ResponseEntity<AcuWeatherDto> getAllergyInfo() {
        return ResponseEntity.ok(acuWeatherClient.getAllergyInfo());
    }

    @GetMapping(value = "/covid")
    public ResponseEntity<CovidDto> getStatsPoland(){
        return ResponseEntity.ok(covidClient.getTestsPoland());
    }
}