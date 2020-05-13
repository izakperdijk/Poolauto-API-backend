package com.poolauto.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Rest_Main_Controller.class)
public class Test_Rest_Main_Controller {

    @Autowired
    private MockMvc mockMvc;

    @Test // Valid request
    public void getRDWInfoOnID_valid() throws Exception {
        final String id = "SJ740T";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isOk());
    }

    @Test // Illegal format exception
    public void getRDWInfoOnID_illegal() throws Exception {
        final String id = "SJ740@";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isBadRequest());
    }

    @Test // No available data exception
    public void getRDWInfoOnID_none() throws Exception {
        final String id = "SJ740A";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isNotFound());
    }

    @Test // TO DO: Server error exception
    public void getRDWInfoOnID_internal() throws Exception {
        //
    }

}

