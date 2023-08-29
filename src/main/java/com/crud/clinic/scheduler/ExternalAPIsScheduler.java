package com.crud.clinic.scheduler;

import com.crud.clinic.client.AccuWeatherClient;
import com.crud.clinic.client.CovidClient;
import com.crud.clinic.mapper.AccuWeatherMapper;
import com.crud.clinic.mapper.CovidMapper;
import com.crud.clinic.service.AccuWeatherService;
import com.crud.clinic.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExternalAPIsScheduler {
    private final AccuWeatherMapper accuWeatherMapper;
    private final CovidMapper covidMapper;
    private final AccuWeatherService accuWeatherService;
    private final CovidService covidService;
    private final AccuWeatherClient accuWeatherClient;
    private final CovidClient covidClient;

    @Scheduled(cron = "0 0 0 * * *")
    public void saveExternalData(){
        covidService.saveData(covidMapper.mapToCovidData(covidClient.getTestsPoland()));
        accuWeatherService.saveData(accuWeatherMapper.mapToAllergiesData(accuWeatherClient.getAllergyInfo()));
        System.out.println("Data was successfully saved");
    }
}