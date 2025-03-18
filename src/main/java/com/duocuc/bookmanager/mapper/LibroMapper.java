package com.duocuc.bookmanager.mapper;

import com.duocuc.bookmanager.dto.LibroDTO;
import com.duocuc.bookmanager.model.LibroEntity;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroEntity libroDtoToEntity(LibroDTO libroDTO) {
        return LibroEntity.builder()
                .titulo(libroDTO.getTitulo())
                .autor(libroDTO.getAutor())
                .anioPublicacion(libroDTO.getAnioPublicacion())
                .genero(libroDTO.getGenero())
                .build();
    }

    public LibroDTO libroEntityToDTO(LibroEntity libroEntity) {
        return LibroDTO.builder()
                .titulo(libroEntity.getTitulo())
                .autor(libroEntity.getAutor())
                .anioPublicacion(libroEntity.getAnioPublicacion())
                .genero(libroEntity.getGenero())
                .build();
    }
}
