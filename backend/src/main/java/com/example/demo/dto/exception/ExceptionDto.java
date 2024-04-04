package com.example.demo.dto.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class ExceptionDto {

    private final String message;
    private final HttpStatus httpStatus;
    private final Integer httpStatusCode;
    private final String path;
    private final Date timestamp;


}