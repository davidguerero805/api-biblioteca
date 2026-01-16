package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Aquí aplicamos el Principio de Responsabilidad Única (SRP):
    // Esta interfaz SOLO se encarga de hablar con la base de datos.
}