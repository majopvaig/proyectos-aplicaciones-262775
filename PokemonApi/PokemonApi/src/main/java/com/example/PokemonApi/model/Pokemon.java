package com.example.PokemonApi.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Pokemon {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio y no puede estar vacío!")
    @Size(min=2, max=50, message = "El nombre debe tener entre 2 y 50 carácteres")
    private String nombre;

    @NotBlank(message = "El tipo es obligatorio y no puede estar vacío!")
    private String tipo;

    @NotNull(message = "El nivel es obligatorio y no puede estar vacío!")
    @Min(value=1, message = "El nivel mínimo es 1!")
    @Max(value=100, message = "El nivel máximo es 100!")
    private Integer nivel;

    @Min(value=0, message = "El ataque no debe ser negativo!")
    private Integer ataque;

    @Min(value=0, message = "La defensa no debe ser negativa!")
    private Integer defensa;

    @Size(max=255, message = "La descripción no puede sobrepasar los 255 carácteres!")
    private String descripcion;

    @URL(message = "La imágen debe ser una URL válida!")
    private String imagenUrl;

    @Email(message = "El formato de correo debe ser válido!")
    private String email;

    @PastOrPresent(message = "La fecha de registro no puede ser a futuro!")
    private LocalDate fechaRegistro;
    
}
