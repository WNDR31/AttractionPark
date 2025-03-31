
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
    console.log('Función mostrarOfertas llamada con categoría:', categoria); // NUEVA LÍNEA
    const botonesOferta = document.querySelectorAll('.boton-oferta');
    const ofertasParque = document.getElementById('ofertas-parque');
    const ofertasRestaurantes = document.getElementById('ofertas-restaurantes');

    botonesOferta.forEach(boton => {
        boton.classList.remove('seleccionado');
    });

    if (categoria === 'parque') {
        if (ofertasParque.style.display === 'flex') {
            ofertasParque.style.display = 'none';
            return;
        }
        ofertasParque.style.display = 'flex';
        ofertasRestaurantes.style.display = 'none';
    } else if (categoria === 'restaurantes') {
        if (ofertasRestaurantes.style.display === 'flex') {
            ofertasRestaurantes.style.display = 'none';
            return;
        }
        ofertasParque.style.display = 'none';
        ofertasRestaurantes.style.display = 'flex';
    }

    botonesOferta.forEach(boton => {
        if (boton.getAttribute('data-categoria') === categoria) {
            boton.classList.add('seleccionado');
            console.log('Clase "seleccionado" añadida al botón de:', categoria); // NUEVA LÍNEA
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {
    console.log('Evento DOMContentLoaded disparado'); // NUEVA LÍNEA
    mostrarOfertas('parque');
});

//---------------------Apartado de testimonios------------------------------------
let currentReview = 0;

function showReview(index) {
    const reviews = document.querySelectorAll('.review-slide');
    const dots = document.querySelectorAll('.pagination-dot');

    if (reviews.length === 0 || dots.length === 0) {
        console.warn('No se encontraron elementos .review-slide o .pagination-dot');
        return;
    }

    reviews.forEach((review, i) => {
        review.classList.remove('active');
        dots[i].classList.remove('active');
    });

    reviews[index].classList.add('active');
    dots[index].classList.add('active');
}


//-----------------------------Suavizar el desplazamiento de horario -> footer------------------------------------------
// Desplazamiento suave al hacer clic en los enlaces con el atributo href que comienza con #
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
      e.preventDefault();
      
      document.querySelector(this.getAttribute('href')).scrollIntoView({
        behavior: 'smooth'
      });
    });
  });


//-----------------------------Calendario footer------------------------------------------
