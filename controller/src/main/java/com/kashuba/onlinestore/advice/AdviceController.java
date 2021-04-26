package com.kashuba.onlinestore.advice;

import com.kashuba.onlinestore.exceptions.HttpException;
import com.kashuba.onlinestore.service.dto.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
