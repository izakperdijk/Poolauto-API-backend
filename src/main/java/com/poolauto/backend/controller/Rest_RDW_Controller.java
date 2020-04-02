package com.poolauto.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.poolauto.backend.model.Auto;

@Service
public class Rest_RDW_Controller {

    private static final String URL_RDW = "https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken="; //SJ740T
    private static final String URL_RDW_BRANDSTOF = "https://opendata.rdw.nl/resource/8ys7-d773.json?kenteken=";

    public String getRelevantAutoGegevens(String id) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objMapper = new ObjectMapper();
    
        // Get basic info
        ResponseEntity<String> response = restTemplate.getForEntity(URL_RDW+id, String.class);
        Auto[] auto = objMapper.readValue(response.getBody(), Auto[].class);

        assert auto.length == 1 : "Could not find kenteken "+id;
        
        // Extended info
        ResponseEntity<String> response_brandstof = restTemplate.getForEntity(URL_RDW_BRANDSTOF+id, String.class);
        JsonNode jsonr = objMapper.readTree(response_brandstof.getBody());

        // Update Auto object with extended info
        ObjectReader reader = objMapper.readerForUpdating(auto[0]);
        Auto updated_auto = reader.readValue(jsonr.get(0));
 
        return updated_auto.toString();
    }
} // java -jar ./target/backend-0.0.1-SNAPSHOT.jar