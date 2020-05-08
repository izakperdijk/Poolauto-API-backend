package com.poolauto.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IllegalFormatException extends ResponseStatusException {
    public IllegalFormatException(String id, Exception e) {
        super(HttpStatus.BAD_REQUEST,
                "Incorrect format found on input: "+id,
                e);
    }
}
