package com.crud.clinic.service;

import com.crud.clinic.domain.CovidData;
import com.crud.clinic.repository.CovidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CovidService {
    private final CovidRepository repository;

    public CovidData saveData(CovidData covidData){return repository.save(covidData);}

    public CovidData findNewest(){return repository.findTopByOrderByIdDesc();}
}
