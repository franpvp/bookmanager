package com.duocuc.bookmanager.controllers.advice;

import com.duocuc.bookmanager.dto.ErrorResponse;
import com.duocuc.bookmanager.exceptions.LibroNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class LibroAdvice {

    @ExceptionHandler(LibroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse manejarLibroNoEncontrado(LibroNotFoundException ex){
        log.error("Libro no encontrado: {}", ex.getMessage());

        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    // Manejo de Excepción NoResourceFoundException
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse manejarRecursoNoEncontrado(NoResourceFoundException ex){
        log.error("Recurso no encontrado: {}", ex.getMessage());

        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
 }
