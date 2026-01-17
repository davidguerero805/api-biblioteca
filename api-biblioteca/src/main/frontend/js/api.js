const API_URL = "http://localhost:8080/api/libros";

export const LibroService = {
    // GET
    async listarTodos() {
        const respuesta = await fetch(API_URL);
        return await respuesta.json();
    },
    // POST
    async guardar(libro) {
        const respuesta = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(libro)
        });
        return await respuesta.json();
    },
    // PUT
    async actualizar(id, libro) {
        const respuesta = await fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(libro)
        });
        return await respuesta.json();
    },
    // DELETE
    async eliminar(id) {
        await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });
    }
};