package com.poolauto.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Rest_Main_Controller {

    @Autowired
    Rest_RDW_Controller rest_rdw_controller = new Rest_RDW_Controller();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRDWInfoOnID(@PathVariable("id") String id) throws IOException {
        return rest_rdw_controller.getRelevantCarInfoJSON(id);
    }

}