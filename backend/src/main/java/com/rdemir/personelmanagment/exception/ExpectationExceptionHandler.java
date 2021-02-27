package com.rdemir.personelmanagment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class ExpectationExceptionHandler extends RuntimeException {

    public ExpectationExceptionHandler() {
        super();
    }

    public ExpectationExceptionHandler(String message) {
        super(message);
    }

    public ExpectationExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpectationExceptionHandler(Throwable cause) {
        super(cause);
    }

    protected ExpectationExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
