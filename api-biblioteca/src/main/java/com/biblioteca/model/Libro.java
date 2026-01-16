package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Indica que esta clase será una tabla en la base de datos
@Data   // Genera automáticamente Getters, Setters y Constructor (Gracias a Lombok)
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único (Encapsulado)

    private String titulo;
    private String autor;
    private String isbn; //Hace referencia numero estandar internacional de libro
    private boolean disponible = true; // Estado inicial del objeto

    // Constructor vacío (Requerido por JPA)
    public Libro() {}

    // Constructor con parámetros (POO para inicializar objetos)
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
}