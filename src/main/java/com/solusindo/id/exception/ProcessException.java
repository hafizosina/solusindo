package com.solusindo.id.exception;

import com.solusindo.id.constant.Default;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ProcessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8951512887557038928L;

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String source;
    private String code;

    public ProcessException(String message, String source, String code) {
        super(message);
        this.source = source;
        this.code = code;
    }

    public ProcessException(String message) {
        super(message);
        this.source = Default.SOURCE;
        this.code = "";
    }
}
