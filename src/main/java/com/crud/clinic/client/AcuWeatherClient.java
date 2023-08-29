package com.crud.clinic.client;

import com.crud.clinic.config.ExternalApiConfig;
import com.crud.clinic.domain.dtos.AcuWeatherDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class AcuWeatherClient {

    private final RestTemplate restTemplate;

    public AcuWeatherDto getAllergyInfo() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://dataservice.accuweather.com/forecasts/v1/daily/5day/274663")
                .queryParam("apikey", "Q5bBRpmXrcwdwvrbHBBwDJDIH0xSi3dP")
                .queryParam("language", "en-us")
                .queryParam("details", "true")
                .queryParam("metric", "true")
                .build()
                .encode()
                .toUri();
        System.out.println("ok");
        String string = restTemplate.getForObject(url, String.class);
        JSONObject object = new JSONObject(string);

        JSONArray array = object.getJSONArray("DailyForecasts");
        JSONObject object1 = array.getJSONObject(0);
        JSONArray array1 = object1.getJSONArray("AirAndPollen");

        JSONObject object2 = array1.getJSONObject(1);
        String grass = object2.getString("Category");
        long grassValue = object2.getLong("Value");

        JSONObject object3 = array1.getJSONObject(2);
        String mold = object3.getString("Category");
        long moldValue = object3.getLong("Value");

        JSONObject object4 = array1.getJSONObject(3);
        String ragweed = object4.getString("Category");
        long ragweedValue = object4.getLong("Value");

        JSONObject object5 = array1.getJSONObject(4);
        String tree = object5.getString("Category");
        long treeValue = object5.getLong("Value");

        return new AcuWeatherDto(grass,grassValue,mold,moldValue,ragweed,ragweedValue,tree,treeValue);
    }
}
