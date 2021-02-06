//package com.rdemir.personelmanagment.exception;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//
//@ControllerAdvice
//public class RestExceptionHandler {
//
//    private final Logger logger= LoggerFactory.getLogger(RestExceptionHandler.class);
//
//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception exception) {
//        logger.error(exception.toString());
//        return exception.getMessage();
//    }
//}
