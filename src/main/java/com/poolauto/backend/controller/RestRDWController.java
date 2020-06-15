package com.poolauto.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.poolauto.backend.model.Auto;

@Service
public class RestRDWController {

    public String getRelevantCarInfoJSON(String id) throws IOException {

        // Set URLs according to external property configuration file
        String urlRdwStd = System.getProperty("rdw.std");
        String urlRdwFuel = System.getProperty("rdw.fuel");

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objMapper = new ObjectMapper();

        // Get standard data
        ResponseEntity<String> response = restTemplate.getForEntity(urlRdwStd+id, String.class);
        Auto[] carArr = objMapper.readValue(Objects.requireNonNull(response.getBody()), Auto[].class);

        // Get fuel data
        ResponseEntity<String> responseFuel = restTemplate.getForEntity(urlRdwFuel+id, String.class);
        JsonNode jsonr = objMapper.readTree(Objects.requireNonNull(responseFuel.getBody()));

        // Update Auto object with fuel data
        ObjectReader reader = objMapper.readerForUpdating(carArr[0]);
        Auto car = reader.readValue(jsonr.get(0));

        return car.toString();
    }

}
