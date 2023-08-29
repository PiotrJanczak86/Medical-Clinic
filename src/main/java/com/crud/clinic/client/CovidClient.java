package com.crud.clinic.client;

import com.crud.clinic.domain.dtos.CovidDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CovidClient {
    private final RestTemplate restTemplate;
    private CovidDto covidDto;
    public CovidDto getTestsPoland() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "3cee0139ddmsh0b59ffec28e9384p1cebf0jsn23b3d97a4176");
        headers.set("X-RapidAPI-Host", "covid-193.p.rapidapi.com");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("https://covid-193.p.rapidapi.com/statistics", HttpMethod.GET, entity, String.class);

        String string = response.getBody();
        JSONObject object1 = new JSONObject(string);
        JSONArray array = object1.getJSONArray("response");
        JSONObject object2 = array.getJSONObject(214);
        JSONObject object3 = object2.getJSONObject("cases");
        long newCases;
        if (object3.isNull("new")){
            newCases = 0L;
        } else newCases = object3.getLong("new");
        JSONObject object4 = object2.getJSONObject("deaths");
        long deaths;
        if (object4.isNull("new")){
            deaths = 0L;
        } else deaths = object4.getLong("new");
        long critical;
        if (object3.isNull("critical")){
            critical = 0L;
        } else critical = object3.getLong("critical");
        return new CovidDto(deaths, newCases, critical);
    }
}
