package com.poolauto.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestMainController.class)
public class RestMainControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test // Valid request
    public void getRDWInfoOnIDvalid200() throws Exception {
        final String id = "SJ740T";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isOk());
    }

    @Test // Illegal format exception
    public void getRDWInfoOnIDillegal400() throws Exception {
        final String id = "SJ740@";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isBadRequest());
    }

    @Test // No available data exception
    public void getRDWInfoOnIDnone404() throws Exception {
        final String id = "SJ740A";
        mockMvc.perform(get("/"+id))
                .andExpect(status().isNotFound());
    }

    @Test // Internal server error exception
    public void getRDWInfoOnIDinternal500() throws Exception {
        final String nobueno = "VBAD00";
        mockMvc.perform(get("/"+nobueno))
                .andExpect(status().isInternalServerError());
    }

}

