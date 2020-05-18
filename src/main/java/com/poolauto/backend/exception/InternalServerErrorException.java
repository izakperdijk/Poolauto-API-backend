package com.poolauto.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InternalServerErrorException extends ResponseStatusException {
    public InternalServerErrorException(Exception e) {
        super(HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error. If the problem persists, please contact an administrator.",
                e);
    }
}
