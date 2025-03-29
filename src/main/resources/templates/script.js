
//Función para mostrar le ventada de compra (modal)
function mostrarVentanaCompra(titulo) {
    
    let modal = new bootstrap.Modal(document.getElementById("modalCompra"));
    modal.show();
}


//Funciones para añadir al carrito
document.getElementById('agregarCarrito').addEventListener('click', function () {
    const tipoEntrada = document.getElementById('tipoEntrada').value;
    const cantidad = document.getElementById('cantidad').value;
    const tipoEntradaText = document.getElementById('tipoEntrada').options[document.getElementById('tipoEntrada').selectedIndex].text;

    if (entradasSeleccionadas.has(tipoEntrada)) {
        alert('Este tipo de entrada ya ha sido añadido al carrito.');
        return;
    }

    if (tipoEntrada === "" || cantidad === "") {
        alert("Opciones incorrectas.");
        return;
    }

    entradasSeleccionadas.add(tipoEntrada);

    const carrito = document.getElementById('carrito');
    const li = document.createElement('li');
    li.className = 'list-group-item d-flex justify-content-between align-items-center';
    li.textContent = `${tipoEntradaText} - Cantidad: ${cantidad}`;
    
    const removeButton = document.createElement('button');
    removeButton.className = 'btn btn-danger btn-sm';
    removeButton.textContent = 'Eliminar';
    removeButton.addEventListener('click', function () {
        carrito.removeChild(li);
        entradasSeleccionadas.delete(tipoEntrada);
    });

    li.appendChild(removeButton);
    carrito.appendChild(li);
});

const entradasSeleccionadas = new Set();


// Función para seleccionar el tipo de promoción
