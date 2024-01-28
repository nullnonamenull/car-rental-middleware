package com.poleszak.carmanagementservice.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public CustomServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.httpStatus = errorCode.getHttpStatus();
    }
}