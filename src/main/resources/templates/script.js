
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
function mostrarOfertas(categoria) {
    const botonesOferta = document.querySelectorAll('.boton-oferta');
    const ofertasParque = document.getElementById('ofertas-parque');
    const ofertasRestaurantes = document.getElementById('ofertas-restaurantes');

    let botonSeleccionado = null;
    botonesOferta.forEach(boton => {
        if (boton.classList.contains('seleccionado')) {
            botonSeleccionado = boton;
        }
        boton.classList.remove('seleccionado');
    });

    if (botonSeleccionado && botonSeleccionado.getAttribute('data-categoria') === categoria) {
        // If the same button is clicked again, hide all content
        ofertasParque.style.display = 'none';
        ofertasRestaurantes.style.display = 'none';
        return;
    }

    botonesOferta.forEach(boton => {
        if (boton.getAttribute('data-categoria') === categoria) {
            boton.classList.add('seleccionado');
        }
    });

    if (categoria === 'parque') {
        ofertasParque.style.display = 'flex'; // or 'block'
        ofertasRestaurantes.style.display = 'none';
    } else if (categoria === 'restaurantes') {
        ofertasParque.style.display = 'none';
        ofertasRestaurantes.style.display = 'flex'; // or 'block'
    }
}

document.addEventListener('DOMContentLoaded', function() {
    mostrarOfertas('parque'); 
});

//Apartado de testimonios
let currentReview = 0;

function showReview(index) {
    // Ocultar todos los testimonios
    const reviews = document.querySelectorAll('.review-slide');
    reviews.forEach((review, i) => {
        review.classList.remove('active');
        document.querySelectorAll('.pagination-dot')[i].classList.remove('active');
    });

    // Mostrar el testimonio seleccionado
    reviews[index].classList.add('active');
    document.querySelectorAll('.pagination-dot')[index].classList.add('active');
}

// Cambiar automáticamente cada 1 segundo
setInterval(() => {
    const reviews = document.querySelectorAll('.review-slide');
    currentReview = (currentReview + 1) % reviews.length;
    showReview(currentReview);
}, 1000);


// Función para crear un calendario
