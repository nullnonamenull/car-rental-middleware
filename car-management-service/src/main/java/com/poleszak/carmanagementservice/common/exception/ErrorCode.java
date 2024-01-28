package com.poleszak.carmanagementservice.common.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
public enum ErrorCode {

    CAR_GROUP_NAME_ALREADY_EXISTS(CONFLICT, "Car group with passed name already exist."),
    CAR_GROUP_NOT_FOUND(NOT_FOUND, "Car group not found.");

    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
