package com.duocuc.bookmanager.repositories;

import com.duocuc.bookmanager.model.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
}
