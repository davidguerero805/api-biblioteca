# 📚 API REST de Biblioteca - Spring Boot
Este proyecto es una API profesional para la gestión de libros, desarrollada como parte de una prueba técnica. Se enfoca en la limpieza del código, la escalabilidad y el uso de estándares de la industria.

## 🚀 Tecnologías Utilizadas
* **Java 17** Y **Spring Boot 3**
* Spring Data JPA: Para el manejo de persistencia.
* H2 Database: Base de datos en memoria para facilitar la portabilidad.
* Lombok: Para reducir el código repetitivo (Boilerplate).

## 🛠️ Arquitectura y Principios (SOLID)
El proyecto sigue una Arquitectura en Capas para separar responsabilidades:
1. Controlador: Gestiona las peticiones HTTP.
2. Servicio: Contiene la lógica de negocio y utiliza interfaces para la Inversión de Dependencias (D de SOLID).
3. Repositorio: Se encarga del acceso a datos.
4. Modelo: Define las entidades de la base de datos.

## 📋 Endpoints Principales
- `GET /api/libros`: Lista todos los libros.
- `POST /api/libros`: Registra un nuevo libro.
- `DELETE /api/libros/{id}`: Elimina un libro por su ID.

## ⚙️ Configuración
La base de datos se inicializa automáticamente con datos de prueba.
- Consola H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`