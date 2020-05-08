package com.poolauto.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poolauto.backend.exception.*;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Rest_Main_Controller {

    private final Rest_RDW_Controller rest_rdw_controller = new Rest_RDW_Controller();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRDWInfoOnID(@PathVariable("id") String id) {
        try {
            return rest_rdw_controller.getRelevantCarInfoJSON(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalFormatException(id, e);
        } catch (IndexOutOfBoundsException e) {
            throw new NoAvailableDataException(id, e);
        } catch (Exception e) {
            throw new ServerErrorException(e);
        }
    }

}
