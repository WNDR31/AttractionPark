
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
    const carritoVacio = document.getElementById('carritoVacio');

    if (carritoVacio) {
        carritoVacio.remove();
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

//Validar Finalizar Compra
document.addEventListener("DOMContentLoaded", function () {
    document.querySelector(".btn-primary").addEventListener("click", function (event) {
        event.preventDefault(); // Evita el envío del formulario por defecto

        // Obtener elementos del formulario
        const nombre = document.getElementById("nombre").value.trim();
        const apellidos = document.getElementById("apellidos").value.trim();
        const telefono = document.getElementById("telefono").value.trim();
        const fechaVisita = document.getElementById("fechaVisita").value.trim();
        const correo = document.getElementById("correo").value.trim();
        
        // Obtener el carrito
        const carrito = document.getElementById("carrito");
        const carritoVacio = document.getElementById("carritoVacio");
        const elementosCarrito = carrito.querySelectorAll("li");
        
        // Validar que los campos obligatorios están rellenados
        if (!nombre || !apellidos || !telefono || !fechaVisita || !correo) {
            alert("Por favor, completa todos los campos del formulario.");
            return;
        }
        
        // Validar que el carrito no está vacío
        if (elementosCarrito.length == 0 || carrito.contains(carritoVacio)) {
            alert("El carrito de la compra está vacío. Añade al menos un ticket antes de finalizar la compra.");
            return;
        }
        
        // Mostrar mensaje de confirmación
        alert("¡Compra realizada con éxito! Recibirás un correo con los detalles de tu compra.");
        
        // Opcional: Resetear formulario y vaciar carrito
        document.getElementById("formCompra").reset();
        carrito.innerHTML = '<li id="carritoVacio" class="list-group-item">Aún no has añadido ningún ticket al carrito</li>';
    });
});


//--------------------Función para seleccionar el tipo de promoción----------------
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

//---------------------Apartado de testimonios------------------------------------
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

//Suavizar el desplazamiento de horario -> footer
// Desplazamiento suave al hacer clic en los enlaces con el atributo href que comienza con #
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      e.preventDefault();
      
      document.querySelector(this.getAttribute('href')).scrollIntoView({
        behavior: 'smooth'
      });
    });
  });
  

// Función para crear un calendario
