package com.duocuc.bookmanager.controllers;


import com.duocuc.bookmanager.dto.EliminarLibroDTO;
import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.model.LibroEntity;
import com.duocuc.bookmanager.services.LibroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerLibros() {
        List<LibroDTO> libros = libroService.obtenerLibros();

        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obteneLibroById(@PathVariable("id") Long id) {
        LibroDTO libroDTO = libroService.obtenerLibroById(id);

        return new ResponseEntity<>(libroDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libroDTO) {
        LibroDTO libroCreado = libroService.crearLibro(libroDTO);

        return new ResponseEntity<>(libroCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> modificarLibro(
            @PathVariable("id") Long id,
            @RequestBody LibroDTO nuevoLibroDTO
            ) {
        LibroDTO libroModificado = libroService.modificarLibro(id, nuevoLibroDTO);

        return new ResponseEntity<>(libroModificado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EliminarLibroDTO> eliminarLibroById(@PathVariable("id") Long id) {
        libroService.eliminarLibroById(id);
        EliminarLibroDTO eliminarLibroDTO = new EliminarLibroDTO("Libro eliminado exitosamente con ID: " + id);

        return ResponseEntity.ok(eliminarLibroDTO);
    }

}
