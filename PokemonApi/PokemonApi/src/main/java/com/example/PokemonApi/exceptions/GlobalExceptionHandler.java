package com.example.PokemonApi.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.PokemonApi.dtos.ErrorDTO;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> manejarValidaciones(MethodArgumentNotValidException ex){
        List<String> detalles = new ArrayList<>();
        for(FieldError f : ex.getBindingResult().getFieldErrors()) {
            detalles.add(f.getField() + ": " + f.getDefaultMessage());
        }

        ErrorDTO e = new ErrorDTO("Error de validación en los datos enviados.", detalles, LocalDateTime.now());

        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> manejarRecursoNoEncontrado(ResourceNotFoundException ex){
        List<String> detalles = new ArrayList<>();
        detalles.add(ex.getMessage());

        ErrorDTO errorDTO = new ErrorDTO(
            "Recurso no Encontrado",
            detalles,
            LocalDateTime.now()
        );

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> manejarExcepcionGlobal(Exception e){
        List<String> detalles = new ArrayList<>();
        detalles.add(e.getLocalizedMessage());

        ErrorDTO errorDTO = new ErrorDTO(
            "Ocurrión un error interno en el servidor",
            detalles,
            LocalDateTime.now()
        );

        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
