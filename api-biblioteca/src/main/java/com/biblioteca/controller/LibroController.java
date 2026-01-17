package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")// Permite la conexion con el frontend
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @GetMapping
    public List<Libro> listar() {
        return libroService.obtenerTodos();
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        return libroService.actualizar(id, libroDetalles); // Asegúrate de tener este método en tu Service
}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
    }
}