package com.crud.clinic.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ExternalApiConfig {

    @Value("http://dataservice.accuweather.com/forecasts/v1/daily/5day/274663")
    private String acuWeatherApiEndpoint;

    @Value("Q5bBRpmXrcwdwvrbHBBwDJDIH0xSi3dP")
    private String acuWeatherApiKey;
}