package com.duocuc.bookmanager.controllers;


import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.services.LibroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/obtener")
    public ResponseEntity<List<LibroDTO>> obtenerLibros() {
        List<LibroDTO> libros = libroService.obtenerLibros();

        return ResponseEntity.ok(libros);
    }
}
