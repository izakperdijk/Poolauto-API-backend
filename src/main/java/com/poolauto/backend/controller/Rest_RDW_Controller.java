package com.poolauto.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.poolauto.backend.model.Auto;
import static com.poolauto.backend.utility.Util.forceFormat;

@Service
public class Rest_RDW_Controller {

    private final ResourceBundle rdw = ResourceBundle.getBundle("rdw");
    private final String URL_RDW = rdw.getString("std");
    private final String URL_RDW_FUEL = rdw.getString("fuel");

    public String getRelevantCarInfoJSON(String id) throws IOException {

        // Validate input format and convert to uppercase
        id = forceFormat(id);

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objMapper = new ObjectMapper();

        // Get standard data
        ResponseEntity<String> response = restTemplate.getForEntity(URL_RDW+id, String.class);
        Auto[] auto = objMapper.readValue(Objects.requireNonNull(response.getBody()), Auto[].class);

        // Get fuel data
        ResponseEntity<String> response_fuel = restTemplate.getForEntity(URL_RDW_FUEL+id, String.class);
        JsonNode jsonr = objMapper.readTree(Objects.requireNonNull(response_fuel.getBody()));

        // Update Auto object with fuel data
        ObjectReader reader = objMapper.readerForUpdating(auto[0]);
        Auto updated_auto = reader.readValue(jsonr.get(0));

        return updated_auto.toString();
    }

} // java -jar ./target/backend-0.0.1-SNAPSHOT.jar
