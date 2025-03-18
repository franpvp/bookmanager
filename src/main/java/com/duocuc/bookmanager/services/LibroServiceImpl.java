package com.duocuc.bookmanager.services;

import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.exceptions.IllegalNumberException;
import com.duocuc.bookmanager.exceptions.LibroBadRequestException;
import com.duocuc.bookmanager.exceptions.LibroServiceException;
import com.duocuc.bookmanager.model.LibroEntity;
import com.duocuc.bookmanager.exceptions.LibroNotFoundException;
import com.duocuc.bookmanager.mapper.LibroMapper;
import com.duocuc.bookmanager.repositories.LibroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    @Override
    public List<LibroDTO> obtenerLibros() {
        List<LibroEntity> libros = libroRepository.findAll();

        if(libros.isEmpty()) {
            throw new LibroNotFoundException("No se encontraron libros");
        }

        return libros.stream()
                .map(libroEntity -> libroMapper.libroEntityToDTO(libroEntity))
                .toList();
    }

    @Override
    public LibroDTO obtenerLibroById(Long id) {

        if (id <= 0) {
            throw new IllegalNumberException("El ID debe ser positivo y no nulo");
        }

        return libroRepository.findById(id)
                .map(libroMapper::libroEntityToDTO)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
    }


    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {
        try {
            if (libroDTO.getTitulo() == null || libroDTO.getTitulo().isEmpty()) {
                throw new LibroBadRequestException("El título del libro es obligatorio.");
            }

            LibroEntity nuevoLibro = libroMapper.libroDtoToEntity(libroDTO);
            LibroEntity libroGuardado = libroRepository.save(nuevoLibro);
            return libroMapper.libroEntityToDTO(libroGuardado);
        } catch (Exception ex) {
            throw new LibroServiceException("Error al crear el libro", ex);
        }
    }

    @Override
    public LibroDTO modificarLibro(Long id, LibroDTO nuevoLibroDTO) {
        if (id < 0) {
            throw new LibroBadRequestException("El ID del libro no puede ser negativo: " + id);
        }

        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(nuevoLibroDTO.getTitulo());
                    libro.setAutor(nuevoLibroDTO.getAutor());
                    libro.setAnioPublicacion(nuevoLibroDTO.getAnioPublicacion());
                    libro.setGenero(nuevoLibroDTO.getGenero());
                    return libroMapper.libroEntityToDTO(libroRepository.save(libro));

                })
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));

    }

    @Override
    public void eliminarLibroById(Long id) {
        if (id < 0) {
            throw new LibroBadRequestException("El ID del libro no puede ser negativo: " + id);
        }

        if (!libroRepository.existsById(id)) {
            throw new LibroNotFoundException("Libro no encontrado con ID: " + id);
        }

        libroRepository.deleteById(id);
    }
}
