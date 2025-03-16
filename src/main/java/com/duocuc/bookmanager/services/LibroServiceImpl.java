package com.duocuc.bookmanager.services;

import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.entities.LibroEntity;
import com.duocuc.bookmanager.exceptions.LibroNotFoundException;
import com.duocuc.bookmanager.mapper.LibroMapper;
import com.duocuc.bookmanager.repositories.LibroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public LibroDTO obtenerLibroById(int id) {
        return null;
    }

//    @Override
//    public LibroDTO crearLibro(LibroDTO libroDTO) {
//
//        try {
//            LibroEntity nuevoLibroEntity = LibroEntity.builder()
//                    .titulo()
//                    .build();
//        } catch (Exception ex) {
//
//        }
//    }

    @Override
    public void modificarLibro(int id, LibroDTO libroDTO) {

    }

    @Override
    public void eliminarLibroById(int id) {

    }
}
