package com.kashuba.onlinestore.advice;

import com.kashuba.onlinestore.dto.ExceptionDto;
import com.kashuba.onlinestore.exceptions.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception e) {
        ExceptionDto exception = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(exception, exception.getStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDto> handleException(AccessDeniedException e) {
        ExceptionDto exception = new ExceptionDto(HttpStatus.FORBIDDEN, e.getMessage());
        log.error(e.getClass() + " : " + exception.getMessage());
        return new ResponseEntity<>(exception, exception.getStatus());
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ExceptionDto> handleException(HttpException e) {
        ExceptionDto exception = new ExceptionDto(e.getStatus(), e.getMessage());
        log.error(e.getClass() + " : " + exception.getMessage());
        return new ResponseEntity<>(exception, exception.getStatus());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDto> handleException(NoSuchElementException e) {
        ExceptionDto exception = new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage());
        log.error(e.getClass() + " : " + exception.getMessage());
        return new ResponseEntity<>(exception, exception.getStatus());
    }
}
