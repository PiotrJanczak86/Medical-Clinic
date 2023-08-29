package com.crud.clinic.controller;

import com.crud.clinic.domain.dtos.AllergiesDataDto;
import com.crud.clinic.domain.dtos.CovidDataDto;
import com.crud.clinic.mapper.AccuWeatherMapper;
import com.crud.clinic.mapper.CovidMapper;
import com.crud.clinic.service.AccuWeatherService;
import com.crud.clinic.service.CovidService;
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

    private final AccuWeatherService accuWeatherService;
    private final AccuWeatherMapper accuWeatherMapper;
    private final CovidService covidService;
    private final CovidMapper covidMapper;

    @GetMapping(value = "/allergy")
    public ResponseEntity<AllergiesDataDto> getAllergyInfo() {
        return ResponseEntity.ok(accuWeatherMapper.mapToAllergiesDataDto(accuWeatherService.findNewest()));
    }

    @GetMapping(value = "/covid")
    public ResponseEntity<CovidDataDto> getStatsPoland(){
        return ResponseEntity.ok(covidMapper.mapToCovidDataDto(covidService.findNewest()));
    }
}