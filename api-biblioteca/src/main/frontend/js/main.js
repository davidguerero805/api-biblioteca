import { LibroService } from './api.js';

const tabla = document.getElementById('tablaLibros');
const formulario = document.getElementById('libroForm');
const btnGuardar = formulario.querySelector('button');

let editandoId = null; // Variable de estado: almacena el ID si estamos editando

async function refrescarTabla() {
    const libros = await LibroService.listarTodos();
    tabla.innerHTML = '';

    libros.forEach(libro => {
        const fila = `
            <tr>
                <td>${libro.id}</td>
                <td><strong>${libro.titulo}</strong></td>
                <td>${libro.autor}</td>
                <td><code>${libro.isbn}</code></td>
                <td><code>${libro.editorial}</code></td>
                <td class="text-center">
                    <but class="btn btn-warning btn-sm btn-editar" 
                        data-id="${libro.id}" 
                        data-titulo="${libro.titulo}" 
                        data-autor="${libro.autor}" 
                        data-isbn="${libro.isbn}"
                        data-editorial="${libro.editorial}">Editar</button>
                    <button class="btn btn-outline-danger btn-sm btn-eliminar" data-id="${libro.id}">Eliminar</button>
                </td>
            </tr>`;
        tabla.innerHTML += fila;
    });

    // Evento Eliminar  
    document.querySelectorAll('.btn-eliminar').forEach(b => {
        b.onclick = async (e) => { await LibroService.eliminar(e.target.dataset.id); refrescarTabla(); };
    });

    // Evento Editar (Cargar datos al formulario)
    document.querySelectorAll('.btn-editar').forEach(b => {
        b.onclick = (e) => {
            const d = e.target.dataset;
            document.getElementById('titulo').value = d.titulo;
            document.getElementById('autor').value = d.autor;
            document.getElementById('isbn').value = d.isbn;
            document.getElementById('editorial').value = d.editorial;

            editandoId = d.id; // Activamos modo edición
            btnGuardar.textContent = "Actualizar";
            btnGuardar.className = "btn btn-warning w-100";
        };
    });
}

formulario.onsubmit = async (e) => {
    e.preventDefault();
    const datos = {
        titulo: document.getElementById('titulo').value,
        autor: document.getElementById('autor').value,
        isbn: document.getElementById('isbn').value,
        editorial: document.getElementById('editorial').value
    };

    if (editandoId) {
        await LibroService.actualizar(editandoId, datos);
        editandoId = null;
        btnGuardar.textContent = "Guardar";
        btnGuardar.className = "btn btn-success w-100";
    } else {
        await LibroService.guardar(datos);
    }

    formulario.reset();
    refrescarTabla();
};

refrescarTabla();

const inputBuscador = document.getElementById('buscador');

inputBuscador.onkeyup = () => {
    const termino = inputBuscador.value.toLowerCase();
    const filas = tabla.getElementsByTagName('tr');

    Array.from(filas).forEach(fila => {
        const textoFila = fila.innerText.toLowerCase();
        // Si el término está en el texto de la fila, se muestra; si no, se oculta
        fila.style.display = textoFila.includes(termino) ? '' : 'none';
    });
};