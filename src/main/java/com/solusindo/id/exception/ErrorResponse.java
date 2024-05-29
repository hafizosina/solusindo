package com.solusindo.id.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String source;
    private final String code;


    public ErrorResponse(ProcessException ex) {
        this.timestamp = LocalDateTime.now();
        this.error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = ex.getMessage();
        this.source = ex.getSource();
        this.code = ex.getCode();
    }
}
