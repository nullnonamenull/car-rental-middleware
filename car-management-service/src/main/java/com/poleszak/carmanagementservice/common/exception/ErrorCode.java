package com.poleszak.carmanagementservice.common.exception;


import lombok.Getter;

@Getter
public enum ErrorCode {
    CAR_GROUP_WITH_NAME_ALREADY_EXIST("Car group with name already exist."),
    CAR_NOT_FOUND("Car not found."),
    INVALID_CAR_STATE("Invalid car state.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

}
