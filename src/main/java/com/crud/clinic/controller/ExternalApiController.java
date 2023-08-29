package com.crud.clinic.controller;

import com.crud.clinic.client.AcuWeatherClient;
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
    @GetMapping
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok(acuWeatherClient.getNewStats());
    }
}