package com.crud.clinic.service;

import com.crud.clinic.domain.AllergiesData;
import com.crud.clinic.repository.AccuWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccuWeatherService {
    private final AccuWeatherRepository repository;
    public AllergiesData saveData(AllergiesData allergiesData){return repository.save(allergiesData);}

    public AllergiesData findNewest(){return repository.findTopByOrderByIdDesc();}
}
