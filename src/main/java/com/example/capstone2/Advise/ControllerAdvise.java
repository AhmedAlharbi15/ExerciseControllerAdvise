package com.example.capstone2.Advise;

import com.example.capstone2.Api.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String massage=e.getMessage();
        return ResponseEntity.status(400).body(massage);

    }
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String massage=e.getMessage();
        return ResponseEntity.status(400).body(massage);
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String massage=e.getMessage();
        return ResponseEntity.status(400).body(massage);
    }
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String massage=e.getMessage();
        return ResponseEntity.status(400).body(massage);
    }
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String massage=e.getMessage();
        return ResponseEntity.status(400).body(massage);
    }

}
