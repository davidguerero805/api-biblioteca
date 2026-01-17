package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Le dice a Spring que este es el "cerebro" del proyecto
public class LibroService implements ILibroService {

    @Autowired // Spring busca el Repositorio y nos lo entrega listo para usar
    private LibroRepository libroRepository;

    @Override
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        // Si el libro es nulo, lanzamos una excepción (Lógica de programación sólida)
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libroDetalles) {
        // Agregamos esta validación para quitar el Warning y dar seguridad
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetalles.getTitulo());
            libro.setAutor(libroDetalles.getAutor());
            libro.setIsbn(libroDetalles.getIsbn());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("No se encontró el libro con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        // Validación de seguridad: si el id es nulo, no intentamos borrar nada
        if (id == null) {
            throw new IllegalArgumentException("El ID para eliminar no puede ser nulo");
        }
        libroRepository.deleteById(id);
    }
}
