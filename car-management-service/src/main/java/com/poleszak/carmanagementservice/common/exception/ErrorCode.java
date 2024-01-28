package com.poleszak.carmanagementservice.common.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@Getter
public enum ErrorCode {
    CAR_GROUP_NAME_ALREADY_EXISTS(CONFLICT, "Car group with passed name already exist.");
//    CAR_NOT_FOUND(HttpStatus.NOT_FOUND, "Car not found."),
//    INVALID_CAR_STATE("Invalid car state.");

    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
