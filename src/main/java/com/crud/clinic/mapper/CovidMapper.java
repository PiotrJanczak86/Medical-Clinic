package com.crud.clinic.mapper;

import com.crud.clinic.domain.CovidData;
import com.crud.clinic.domain.dtos.CovidDataDto;
import com.crud.clinic.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CovidMapper {
    @Autowired
    CovidService service;

    public CovidDataDto mapToCovidDataDto(final CovidData covidData) {
        return new CovidDataDto(covidData.getDeaths(), covidData.getCases(), covidData.getCritical());
    }

    public CovidData mapToCovidData(final CovidDataDto covidDataDto){
        return new CovidData(null, LocalDate.now(), covidDataDto.getDeaths(), covidDataDto.getCases(), covidDataDto.getCritical());
    }
}
