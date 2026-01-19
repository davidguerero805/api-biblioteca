package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Indica que esta clase será una tabla en la base de datos
@Data   // Genera automáticamente Getters, Setters y Constructor 
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String titulo;
    private String autor;
    private String isbn; //Hace referencia numero estandar internacional de libro
    private String editorial;
    private boolean disponible = true; 

    // Constructor vacío (Requerido por JPA)
    public Libro() {}

    // Constructor con parámetros
    public Libro(String titulo, String autor, String isbn,String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
    }
}