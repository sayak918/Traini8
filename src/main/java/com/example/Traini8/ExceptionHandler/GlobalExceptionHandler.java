package com.example.Traini8.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>validationExceptionHandler(MethodArgumentNotValidException exception){

        Map<String,String>exceptions=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String field=((FieldError)error).getField();
            String errorMsg=error.getDefaultMessage();
            exceptions.put(field,errorMsg);
        });
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }
}
