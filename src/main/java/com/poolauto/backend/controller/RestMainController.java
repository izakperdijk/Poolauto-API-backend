package com.poolauto.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.poolauto.backend.exception.*;

@RestController
public class RestMainController {

    private final RestRDWController restRdwController = new RestRDWController();

    @GetMapping(value = "/{id}")
    public String getRDWInfoOnID(@PathVariable("id") String id) {
        try {
            return restRdwController.getRelevantCarInfoJSON(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalFormatException(id, e);
        } catch (IndexOutOfBoundsException e) {
            throw new NoAvailableDataException(id, e);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }

}
