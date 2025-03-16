package com.duocuc.bookmanager.services;

import com.duocuc.bookmanager.dto.LibroDTO;

import java.util.List;

public interface LibroService {

    List<LibroDTO> obtenerLibros();
    LibroDTO obtenerLibroById(int id);
    // LibroDTO crearLibro(LibroDTO libroDTO);
    void modificarLibro(int id, LibroDTO libroDTO);
    void eliminarLibroById(int id);
}
