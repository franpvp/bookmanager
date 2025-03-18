package com.duocuc.bookmanager.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "autor", length = 50)
    private String autor;

    @Column(name = "anio_publicacion")
    private int anioPublicacion;

    @Column(name = "genero", length = 50)
    private String genero;

}
