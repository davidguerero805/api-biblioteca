package com.biblioteca.config;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(LibroRepository repository) {
        return args -> {
            // Creamos libros de prueba (POO en acción)
            repository.save(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728","pollito"));
            repository.save(new Libro("El código Da Vinci", "Dan Brown", "978-0307474278","ITA"));
            repository.save(new Libro("SOLID con Java", "Mentor Gemini", "123-4567890123","Planeta"));
            
            System.out.println(">> Base de Datos Inicializada con libros de prueba.");
        };
    }
}