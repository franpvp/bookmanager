package com.duocuc.bookmanager.dto;

import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {

    @NotNull(message = "El campo titulo no puede estar vacío")
    @Size(min = 10, max = 50, message = "El campo titulo debe tener entre 10 y 50 caracteres")
    private String titulo;

    @NotNull(message = "El campo autor no puede estar vacío")
    @Size(min = 10, max = 50, message = "El campo autor debe tener entre 10 y 50 caracteres")
    private String autor;

    @NotNull(message = "El campo anioPublicacion no puede estar vacío")
    private int anioPublicacion;

    @NotNull(message = "El campo genero no puede estar vacío")
    @Size(min = 10, max = 50, message = "El campo genero debe tener entre 10 y 50 caracteres")
    private String genero;


}
