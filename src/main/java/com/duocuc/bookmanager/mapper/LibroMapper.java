package com.duocuc.bookmanager.mapper;

import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.entities.LibroEntity;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    // Transforma el Entity de Libro a DTO
    public LibroDTO libroEntityToDTO(LibroEntity libroEntity) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setIdLibro(libroEntity.getIdLibro());
        libroDTO.setTitulo(libroEntity.getTitulo());
        libroDTO.setAutor(libroEntity.getAutor());
        libroDTO.setAnioPublicacion(libroEntity.getAnioPublicacion());
        libroDTO.setGenero(libroEntity.getGenero());

        return libroDTO;
    }

    // Transforma el DTO de Libro a Entity
//    public LibroEntity libroDtoToEntity(LibroDTO libroDTO) {
//        return LibroEntity.builder()
//                .idLibro(libroDTO.getIdLibro())
//                .titulo(libroDTO.getTitulo())
//                .autor(libroDTO.getAutor())
//                .anioPublicacion(libroDTO.getAnioPublicacion())
//                .genero(libroDTO.getGenero())
//                .build();
//    }
}
