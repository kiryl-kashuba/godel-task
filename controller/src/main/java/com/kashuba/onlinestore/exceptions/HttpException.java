package com.kashuba.onlinestore.exceptions;

import lombok.NonNull;
import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException {

    private final HttpStatus status;

    public HttpException(@NonNull String strung, @NonNull HttpStatus status) {
        super(strung);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}