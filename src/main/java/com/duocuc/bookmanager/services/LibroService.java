package com.duocuc.bookmanager.services;

import com.duocuc.bookmanager.dto.LibroDTO;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<LibroDTO> obtenerLibros();
    LibroDTO obtenerLibroById(Long id);

    LibroDTO crearLibro(LibroDTO libroDTO);

    // LibroDTO crearLibro(LibroDTO libroDTO);
    LibroDTO modificarLibro(Long id, LibroDTO libroDTO);
    void eliminarLibroById(Long id);
}
