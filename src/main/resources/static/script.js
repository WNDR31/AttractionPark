//Función para mostrar le ventada de compra (modal)
function mostrarVentanaCompra(titulo) {
    
    let modal = new bootstrap.Modal(document.getElementById("modalCompra"));
    modal.show();
}

// Cambiar de Set a un Set que almacene arrays (simulando tuplas)
const entradasSeleccionadas = new Set();

// Función para añadir al carrito
document.getElementById('agregarCarrito').addEventListener('click', function () {
    const tipoEntrada = document.getElementById('tipoEntrada').value;
    const cantidad = document.getElementById('cantidad').value;
    const tipoEntradaText = document.getElementById('tipoEntrada').options[document.getElementById('tipoEntrada').selectedIndex].text;

    if (tipoEntrada === "" || cantidad === "") {
        alert("Opciones incorrectas. Por favor, selecciona un tipo de entrada y una cantidad válida.");
        return;
    }


    // Crear una "tupla" (array) con el tipo de entrada y la cantidad
    const entrada = [tipoEntrada, cantidad];

    // Verificar si ya existe una entrada con el mismo tipo
    for (let item of entradasSeleccionadas) {
        if (item[0] === tipoEntrada) {
            alert('Este tipo de entrada ya ha sido añadido al carrito.');
            return;
        }
    }

    const carritoVacio = document.getElementById('carritoVacio');
    if (carritoVacio) {
        carritoVacio.remove();
    }

        //Para que solo se pueda añadir una entrada (todavía 1:1)
    if (entradasSeleccionadas.size > 0) {
        alert("Solo puedes añadir un tipo de entrada al carrito.");
        return;
    }

    // Añadir la "tupla" al Set
    entradasSeleccionadas.add(entrada);

    

    const carrito = document.getElementById('carrito');
    const li = document.createElement('li');
    li.className = 'list-group-item d-flex justify-content-between align-items-center';
    li.textContent = `${tipoEntradaText} - Cantidad: ${cantidad}`;

    const removeButton = document.createElement('button');
    removeButton.className = 'btn btn-danger btn-sm';
    removeButton.textContent = 'Eliminar';
    removeButton.addEventListener('click', function () {
        carrito.removeChild(li);
        entradasSeleccionadas.delete(entrada);
    });

    li.appendChild(removeButton);
    carrito.appendChild(li);
});

//-----------------------------Enviar formulario de compra------------------------------------------
document.getElementById('formCompra').addEventListener('submit', function(event) {
    console.log("¡Función de envío del formulario INICIADA!");
    event.preventDefault(); // Evita el envío normal del formulario

    // Validar que el carrito no está vacío
    const carrito = document.getElementById('carrito');
    const carritoVacio = document.getElementById('carritoVacio');
    const elementosCarrito = carrito.querySelectorAll('li');

    if (elementosCarrito.length === 0 || carrito.contains(carritoVacio)) {
        alert("El carrito de la compra está vacío. Añade al menos un ticket antes de finalizar la compra.");
        return;
    }

    const nombre = document.getElementById('nombre').value;
    const apellidos = document.getElementById('apellidos').value;
    const telefono = document.getElementById('telefono').value;
    const fechaVisita = document.getElementById('fechaVisita').value;
    const correo = document.getElementById('correo').value;
    const entrada = entradasSeleccionadas.values().next().value; // Obtener la primera entrada del Set
    const tipoEntrada = entrada[0]; // Tipo de entrada
    const cantidad = entrada[1]; // Cantidad de entradas

    const reservationData = {
        name: nombre,
        surname: apellidos,
        phone: telefono,
        date: fechaVisita,
        email: correo,
        entryType: tipoEntrada,
        quantity: cantidad
    };

    fetch('http://localhost:8080/reservations', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reservationData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la petición: ' + response.status);
        }
        return response.json();
    })
    .then(data => {
        console.log('Reserva creada:', data);
        alert('¡Gracias por tu compra! Tu ID de reserva es: ' + data.id + '. Te enviaremos un email con los datos de reserva.');
    })
    .catch(error => {
        console.error('Error al crear la reserva:', error);
        alert('Error al crear la reserva. Consulta la consola para más detalles.');
    });
});

//--------------------Función para eliminar reserva-----------------
// Ocultar el formulario al cargar la página
document.addEventListener('DOMContentLoaded', function () {
    const formulario = document.getElementById('formularioEliminarReserva');
    formulario.style.display = 'none';
});

// Mostrar/ocultar el formulario al hacer clic en el botón
document.getElementById('mostrarFormularioEliminar').addEventListener('click', function () {
    const formulario = document.getElementById('formularioEliminarReserva');
    if (formulario.style.display === 'none') {
        formulario.style.display = 'block';
    } else {
        formulario.style.display = 'none';
    }
});

// Manejar la eliminación
document.getElementById('eliminarReserva').addEventListener('click', function () {
    const idReserva = document.getElementById('idReservaEliminar').value;

    if (!idReserva) {
        alert('Por favor, introduce el ID de la reserva que deseas eliminar.');
        return;
    }

    // Confirmar antes de eliminar
    if (!confirm('¿Estás seguro de que deseas eliminar esta reserva?')) {
        return;
    }

    // Enviar la solicitud DELETE al backend
    fetch(`http://localhost:8080/reservations/${idReserva}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al eliminar la reserva: ' + response.status);
            }
            alert('Reserva eliminada con éxito.');
            // Ocultar el formulario
            document.getElementById('formularioEliminarReserva').style.display = 'none';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('No se pudo eliminar la reserva. Revisa el ID introducido por favor.');
        });
});
//--------------------Función para modificar datos reserva----------------
// Ocultar el formulario al cargar la página
document.addEventListener('DOMContentLoaded', function () {
    const formularioModificar = document.getElementById('formularioModificarReserva');
    if (formularioModificar) { // Verificar si el formulario existe en la página
        formularioModificar.style.display = 'none';
    }
});

// Mostrar/ocultar el formulario de modificación al hacer clic en el botón
const mostrarFormularioModificarBtn = document.getElementById('mostrarFormularioModificar'); // Asegúrate de que este botón exista en tu HTML
if (mostrarFormularioModificarBtn) { // Verificar si el botón existe en la página
    mostrarFormularioModificarBtn.addEventListener('click', function () {
        const formularioModificar = document.getElementById('formularioModificarReserva');
        if (formularioModificar) { // Verificar si el formulario existe de nuevo por si acaso
            if (formularioModificar.style.display === 'none') {
                formularioModificar.style.display = 'block';
            } else {
                formularioModificar.style.display = 'none';
            }
        }
    });
}


// Manejar la modificación
const modificarReservaBtn = document.getElementById('modificarReserva');
if (modificarReservaBtn) { // Verificar si el botón existe en la página
    modificarReservaBtn.addEventListener('click', function () {
        const idReserva = document.getElementById('idReservaModificar').value;
        const campoModificar = document.getElementById('campoModificar').value;
        const nuevoValor = document.getElementById('nuevoValor').value;

        if (!idReserva) {
            alert('Por favor, introduce el ID de la reserva que deseas modificar.');
            return;
        }

        if (!campoModificar) {
            alert('Por favor, selecciona el campo que deseas modificar.');
            return;
        }

        if (!nuevoValor) {
            alert('Por favor, introduce el nuevo valor para el campo seleccionado.');
            return;
        }

        // Confirmar antes de modificar (opcional, pero recomendable)
        if (!confirm(`¿Estás seguro de que deseas modificar el campo "${campoModificar}" de la reserva con ID ${idReserva} al valor "${nuevoValor}"?`)) {
            return;
        }

        // Enviar la solicitud PATCH al backend
        fetch(`http://localhost:8080/reservations/${idReserva}`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                [campoModificar]: nuevoValor // Usamos notación de corchetes para usar el valor de campoModificar como clave
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al modificar la reserva: ' + response.status);
                }
                return response.json(); // Opcional: Si tu backend devuelve la reserva modificada, puedes procesarla aquí
            })
            .then(updatedReservation => { // Opcional: Recibe la reserva modificada si el backend la devuelve
                alert('Reserva modificada con éxito.');
                // Ocultar el formulario de modificación
                const formularioModificar = document.getElementById('formularioModificarReserva'); // Obtener el formulario de nuevo
                if (formularioModificar) {
                    formularioModificar.style.display = 'none';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('No se pudo modificar la reserva. Revisa el ID, el campo y el valor introducidos por favor.');
            });
    });
}

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
function showReview(index) {
    console.log("showReview called with index:", index);
    const reviews = document.querySelectorAll('.review-slide');
    const dots = document.querySelectorAll('.pagination-dot');
    console.log("Number of review-slide elements found:", reviews.length);
    console.log("Number of pagination-dot elements found:", dots.length); 

    if (reviews.length === 0 || dots.length === 0) {
        console.warn('No se encontraron elementos .review-slide o .pagination-dot');
        return;
    }
    if (index >= reviews.length) {
        currentReview = 0;
    } else if (index < 0) {
        currentReview = reviews.length - 1;
    } else {
        currentReview = index;
    }

    reviews.forEach((review, i) => {
        review.classList.remove('active');
    });
    dots.forEach((dot, i) => {  
        dots[i].classList.remove('active');
    });

    reviews[currentReview].classList.add('active');
    dots[currentReview].classList.add('active');
}
function nextReview() {
    console.log("nextReview called"); 
    showReview(currentReview + 1);
}

function prevReview() {
    console.log("prevReview called"); 
    showReview(currentReview - 1);
}

showReview(currentReview);

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


//-----------------------------Funcion seleccionar modificar o eliminar------------------------------------------
document.addEventListener('DOMContentLoaded', function() {
    const mostrarFormularioEliminarBtn = document.getElementById('mostrarFormularioEliminar');
    const mostrarFormularioModificarBtn = document.getElementById('mostrarFormularioModificar');
    const formularioEliminarReservaDiv = document.getElementById('formularioEliminarReserva');
    const formularioModificarReservaDiv = document.getElementById('formularioModificarReserva');

    mostrarFormularioEliminarBtn.addEventListener('click', function() {
        if (mostrarFormularioEliminarBtn.classList.contains('active')) {
            mostrarFormularioEliminarBtn.classList.remove('active');
            formularioEliminarReservaDiv.style.display = 'none';
        } else {
            mostrarFormularioEliminarBtn.classList.add('active');
            mostrarFormularioModificarBtn.classList.remove('active');
            formularioEliminarReservaDiv.style.display = 'block';
            formularioModificarReservaDiv.style.display = 'none';
        }
    });

    mostrarFormularioModificarBtn.addEventListener('click', function() {
        if (mostrarFormularioModificarBtn.classList.contains('active')) {
            mostrarFormularioModificarBtn.classList.remove('active');
            formularioModificarReservaDiv.style.display = 'none';
        } else {
            mostrarFormularioModificarBtn.classList.add('active');
            mostrarFormularioEliminarBtn.classList.remove('active');
            formularioModificarReservaDiv.style.display = 'block';
            formularioEliminarReservaDiv.style.display = 'none';
        }
    });
});

