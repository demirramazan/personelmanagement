package com.rdemir.personelmanagment.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResult> exceptionHandler(Exception exception) {
        logger.error(exception.toString());
        return getExceptionResult(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ResponseEntity<ExceptionResult> exceptionNotFoundHandler(Exception exception) {
        logger.error(exception.toString());
        return getExceptionResult(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConfictExceptionHandler.class)
    public ResponseEntity<ExceptionResult> exceptionConflictHandler(Exception exception) {
        logger.error(exception.toString());
        return getExceptionResult(exception, HttpStatus.CONFLICT);
    }

    private ResponseEntity<ExceptionResult> getExceptionResult(Exception exception, HttpStatus status) {
        ExceptionResult exceptionResult = new ExceptionResult();
        exceptionResult.setResultCode(status.value());
        exceptionResult.setResultMessage(exception.getMessage());
        exceptionResult.setResultMessageDetail(exception.toString());
        return new ResponseEntity<>(exceptionResult, status);
    }
}
