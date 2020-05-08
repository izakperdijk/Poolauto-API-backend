package com.poolauto.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoAvailableDataException extends ResponseStatusException {
    public NoAvailableDataException(String id, Exception e) {
        super(HttpStatus.NOT_FOUND,
                "No available data for "+id,
                e);
    }
}
