package com.kashuba.onlinestore.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDto {

    private HttpStatus status;

    private String message;
}
