package com.exam.exception;

import com.exam.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(
            Exception ex) {

        ErrorResponseDto response =
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Something went wrong. Please try again later.");

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleSubjectNotFound(
            SubjectNotFoundException ex) {

        ErrorResponseDto response =
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage());

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleClassNotFound(
            ClassNotFoundException ex) {

        ErrorResponseDto response =
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage());

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaperNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePaperNotFound(
            PaperNotFoundException ex) {

        ErrorResponseDto response =
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getMessage());

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

}
