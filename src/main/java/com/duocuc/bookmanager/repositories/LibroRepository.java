package com.duocuc.bookmanager.repositories;

import com.duocuc.bookmanager.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {
}
