package com.crud.clinic.mapper;

import com.crud.clinic.domain.AllergiesData;
import com.crud.clinic.domain.dtos.AllergiesDataDto;
import com.crud.clinic.service.AccuWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccuWeatherMapper {

    public AllergiesDataDto mapToAllergiesDataDto(AllergiesData allergiesData) {
        return new AllergiesDataDto(allergiesData.getGrass(), allergiesData.getGrassValue(), allergiesData.getMold(), allergiesData.getMoldValue(),
                allergiesData.getRagweed(), allergiesData.getRagweedValue(), allergiesData.getTree(), allergiesData.getTreeValue());
    }

    public AllergiesData mapToAllergiesData(AllergiesDataDto allergiesDataDto) {
        return new AllergiesData(null, LocalDate.now(), allergiesDataDto.getGrass(), allergiesDataDto.getGrassValue(), allergiesDataDto.getMold(),
                allergiesDataDto.getMoldValue(), allergiesDataDto.getRagweed(), allergiesDataDto.getRagweedValue(), allergiesDataDto.getTree(), allergiesDataDto.getTreeValue());
    }
}
