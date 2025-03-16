package com.duocuc.bookmanager.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libro")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idLibro;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "autor", length = 50)
    private String autor;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @Column(name = "genero", length = 50)
    private String genero;

}
