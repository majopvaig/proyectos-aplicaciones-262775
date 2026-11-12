package com.example.PokemonApi.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ErrorDTO {
    
    private String message;

    private List<String> detalles;

    private LocalDateTime fecha;
}
