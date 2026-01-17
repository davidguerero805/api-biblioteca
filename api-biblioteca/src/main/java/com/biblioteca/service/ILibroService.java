package com.biblioteca.service; // Asegúrate de que esta ruta coincida con tus carpetas

import com.biblioteca.model.Libro;
import java.util.List;

public interface ILibroService {
    List<Libro> obtenerTodos();
    Libro guardar(Libro libro);
    Libro actualizar(Long id, Libro libroDetalles);
    void eliminar(Long id);
}