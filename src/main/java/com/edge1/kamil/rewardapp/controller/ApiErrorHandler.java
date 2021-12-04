package com.edge1.kamil.rewardapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestControllerAdvice
class ApiErrorHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(
            CustomApiException ex) {
        ApiErrorResponse response =
                new ApiErrorResponse("error-0001",
                        "No element found with ID " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

@Setter
@Getter
@AllArgsConstructor
class ApiErrorResponse {

    private String error;
    private String message;
}