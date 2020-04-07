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
public class Rest_RDW_Controller {

    private static final String URL_RDW = "https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="; //SJ740T
    private static final String URL_RDW_FUEL = "https://opendata.rdw.nl/resource/8ys7-d773.json?kenteken=";

    public String getRelevantCarInfoJSON(String id) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objMapper = new ObjectMapper();
    
        // Get basic info
        ResponseEntity<String> response = restTemplate.getForEntity(URL_RDW+id, String.class);
        if (!response.hasBody()) throw new IOException("No response body for "+URL_RDW+id);
        Auto[] auto = objMapper.readValue(Objects.requireNonNull(response.getBody()), Auto[].class);
        if (auto.length != 1) throw new IOException("No data available for kenteken "+id);

        // Extended info
        ResponseEntity<String> response_fuel = restTemplate.getForEntity(URL_RDW_FUEL+id, String.class);
        if (!response_fuel.hasBody()) throw new IOException("No response body for "+URL_RDW_FUEL+id);
        JsonNode jsonr = objMapper.readTree(Objects.requireNonNull(response_fuel.getBody()));
        if (jsonr.size() != 1) throw new IOException("No fuel data available for kenteken "+id);

        // Update Auto object with extended info
        ObjectReader reader = objMapper.readerForUpdating(auto[0]);
        Auto updated_auto = reader.readValue(jsonr.get(0));

        return updated_auto.toString();
    }
} // java -jar ./target/backend-0.0.1-SNAPSHOT.jar