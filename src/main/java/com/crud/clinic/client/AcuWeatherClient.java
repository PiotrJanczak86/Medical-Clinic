package com.crud.clinic.client;

import com.crud.clinic.config.ExternalApiConfig;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class AcuWeatherClient {

    private final RestTemplate restTemplate;
    private final ExternalApiConfig config;

    public String getStats() {
        URI url = UriComponentsBuilder
                .fromHttpUrl(config.getAcuWeatherApiEndpoint())
                .queryParam("apikey", config.getAcuWeatherApiKey())
                .queryParam("language", "en-us")
                .queryParam("details", "true")
                .queryParam("metric", "true")
                .build()
                .encode()
                .toUri();
        System.out.println("ok");
        String obj = restTemplate.getForObject(url, String.class);
        JSONObject object = new JSONObject(obj);

        JSONArray result1 = object.getJSONArray("DailyForecasts");
        JSONObject result2 = result1.getJSONObject(0);
        JSONArray result3 = result2.getJSONArray("AirAndPollen");
        JSONObject result4 = result3.getJSONObject(0);
        String result5 = result4.getString("Category");
        return result5;
    }

    public String getNewStats() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "3cee0139ddmsh0b59ffec28e9384p1cebf0jsn23b3d97a4176");
        headers.set("X-RapidAPI-Host", "covid-193.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("https://covid-193.p.rapidapi.com/statistics", HttpMethod.GET, entity, String.class);

        String obj = response.getBody();

        JSONObject object = new JSONObject(obj);
        return object.getString("get");
    }
}
