package com.rdemir.personelmanagment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConfictExceptionHandler extends RuntimeException{

    public ConfictExceptionHandler() {
        super();
    }

    public ConfictExceptionHandler(String message) {
        super(message);
    }

    public ConfictExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfictExceptionHandler(Throwable cause) {
        super(cause);
    }

    protected ConfictExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
