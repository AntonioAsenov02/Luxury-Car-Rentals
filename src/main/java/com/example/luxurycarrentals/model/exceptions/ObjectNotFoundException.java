package com.example.luxurycarrentals.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    private final Long objectId;

    public ObjectNotFoundException(Long objectId) {
        this.objectId = objectId;
    }

    public Long getObjectId() {
        return objectId;
    }
}
