//---------------------Reviews Section------------------------------------

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
showReview(0);

function nextReview() {
    console.log("nextReview called");
    showReview(currentReview + 1);
}

function prevReview() {
    console.log("prevReview called");
    showReview(currentReview - 1);
}

document.addEventListener('DOMContentLoaded', function () {
    console.log('Evento DOMContentLoaded disparado');
    showReview(0);
});



//--------------------Function to select the type of promotion----------------
function mostrarOfertas(categoria) {
    console.log('Función mostrarOfertas llamada con categoría:', categoria); 
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
            console.log('Clase "seleccionado" añadida al botón de:', categoria); 
        }
    });
}

document.addEventListener('DOMContentLoaded', function() {
    console.log('Evento DOMContentLoaded disparado'); 
    mostrarOfertas('parque');
});



//--------------------Buy Modal Section----------------

function mostrarVentanaCompra(titulo) {
    
    let modal = new bootstrap.Modal(document.getElementById("modalCompra"));
    modal.show();
}
// Function to handle the adding of tickets to the cart
document.addEventListener("DOMContentLoaded", () => {
    const carrito = document.getElementById("carrito");
    const carritoVacio = document.getElementById("carritoVacio");
    const agregarCarritoButton = document.getElementById("agregarCarrito");

    // Keep an array to track added tickets
    let carritoTickets = [];

    // Event listener for adding tickets to the cart
    agregarCarritoButton.addEventListener("click", () => {
        const select = document.getElementById("tipoEntrada");
        const ticketId = select.value;  // Get the selected ticket ID
        const ticketName = select.options[select.selectedIndex].textContent; // Get the name of the selected ticket

        // If no ticket is selected, exit the function
        if (!ticketId) {
            alert("Por favor, selecciona un tipo de entrada.");
            return;
        }

        // Create a ticket object to represent this selection
        const ticket = {
            id: ticketId,
            name: ticketName
        };

        // Add the ticket to the carritoTickets array
        carritoTickets.push(ticket);

        // Update the UI to show the added ticket
        updateCarritoUI();

    });

    // Function to update the UI for the shopping cart
    function updateCarritoUI() {
        // Clear the carrito to redraw it
        carrito.innerHTML = '';

        // If there are no tickets in the carrito, show the "Carrito Vacio" message
        if (carritoTickets.length === 0) {
            carritoVacio.style.display = 'block';
        } else {
            carritoVacio.style.display = 'none';
            
            // Add each ticket in the carritoTickets array to the UI
            carritoTickets.forEach(ticket => {
                const li = document.createElement("li");
                li.classList.add("list-group-item");
                li.textContent = ticket.name;

                // Store the ticket ID as a data attribute in the li
                li.dataset.ticketId = ticket.id;

                // Create the remove button for this ticket
                const removeButton = document.createElement("button");
                removeButton.classList.add("btn", "btn-danger", "btn-sm", "ms-3");
                removeButton.textContent = "Eliminar";
                removeButton.addEventListener("click", () => {
                    // Remove the ticket from the carritoTickets array
                    carritoTickets = carritoTickets.filter(t => t.id !== ticket.id);

                    // Update the UI again after removal
                    updateCarritoUI();
                });

                // Append the remove button to the list item
                li.appendChild(removeButton);

                // Append the new ticket to the carrito
                carrito.appendChild(li);
            });
        }
    }
});

// Function to send the form
document.getElementById('formCompra').addEventListener('submit', function(event) {
    console.log("¡Función de envío del formulario INICIADA!");
    event.preventDefault(); // Prevent the default form submission

    // Validate that the shopping cart is not empty
    const carrito = document.getElementById('carrito');
    const carritoVacio = document.getElementById('carritoVacio');
    const elementosCarrito = carrito.querySelectorAll('li');

    if (elementosCarrito.length === 0 || carrito.contains(carritoVacio)) {
        alert("El carrito de la compra está vacío. Añade al menos un ticket antes de finalizar la compra.");
        return;
    }

    // Get form values
    const nombre = document.getElementById('nombre').value;
    const apellidos = document.getElementById('apellidos').value;
    const telefono = document.getElementById('telefono').value;
    const fechaVisita = document.getElementById('fechaVisita').value;
    const correo = document.getElementById('correo').value;

    // Get the tickets from the cart
    const carritoTickets = [];
    const itemsCarrito = carrito.querySelectorAll('li');
    itemsCarrito.forEach(item => {
        if (item.id !== 'carritoVacio') {
            carritoTickets.push({
                id: item.dataset.ticketId, // Get the ticket ID from the data attribute
                name: item.textContent.replace('Eliminar', '').trim() // Remove the "Eliminar" text
            });
        }
    });

    // Validate that there are tickets in the cart
    if (carritoTickets.length === 0) {
        alert("No has seleccionado ningún ticket para la compra.");
        return;
    }

    // Prepare the reservation data
    const reservationData = {
        name: nombre,
        surname: apellidos,
        phone: telefono,
        date: fechaVisita,
        email: correo,
        tickets: carritoTickets // Add the selected tickets
    };

    // Make the POST request to the server
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




//--------------------Function to delete reservation-----------------
// Hide the form when the page loads
document.addEventListener('DOMContentLoaded', function () {
    const formulario = document.getElementById('formularioEliminarReserva');
    formulario.style.display = 'none';
});

// Show/hide the form when clicking the button
document.getElementById('mostrarFormularioEliminar').addEventListener('click', function () {
    const formulario = document.getElementById('formularioEliminarReserva');
    if (formulario.style.display === 'none') {
        formulario.style.display = 'block';
    } else {
        formulario.style.display = 'none';
    }
});

// Handle deletion
document.getElementById('eliminarReserva').addEventListener('click', function () {
    const idReserva = document.getElementById('idReservaEliminar').value;

    if (!idReserva) {
        alert('Por favor, introduce el ID de la reserva que deseas eliminar.');
        return;
    }

    if (!confirm('¿Estás seguro de que deseas eliminar esta reserva?')) {
        return;
    }

    fetch(`http://localhost:8080/reservations/${idReserva}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al eliminar la reserva: ' + response.status);
            }
            alert('Reserva eliminada con éxito.');
            document.getElementById('formularioEliminarReserva').style.display = 'none';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('No se pudo eliminar la reserva. Revisa el ID introducido por favor.');
        });
});



//--------------------Function to modify reservation data----------------
// Hide the form when the page loads
document.addEventListener('DOMContentLoaded', function () {
    const formularioModificar = document.getElementById('formularioModificarReserva');
    if (formularioModificar) { 
        formularioModificar.style.display = 'none';
    }
});

// Show/hide the modification form when clicking the button
const mostrarFormularioModificarBtn = document.getElementById('mostrarFormularioModificar'); 
if (mostrarFormularioModificarBtn) { 
    mostrarFormularioModificarBtn.addEventListener('click', function () {
        const formularioModificar = document.getElementById('formularioModificarReserva');
        if (formularioModificar) { 
            if (formularioModificar.style.display === 'none') {
                formularioModificar.style.display = 'block';
            } else {
                formularioModificar.style.display = 'none';
            }
        }
    });
}

// Handle the modification process
const modificarReservaBtn = document.getElementById('modificarReserva');
if (modificarReservaBtn) { 
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

        if (!confirm(`¿Estás seguro de que deseas modificar el campo "${campoModificar}" de la reserva con ID ${idReserva} al valor "${nuevoValor}"?`)) {
            return;
        }

        fetch(`http://localhost:8080/reservations/${idReserva}`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                [campoModificar]: nuevoValor // Using bracket notation to use the value of campoModificar as the key
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al modificar la reserva: ' + response.status);
                }
                return response.json(); 
            })
            .then(updatedReservation => { 
                alert('Reserva modificada con éxito.');
                // Ocultar el formulario de modificación
                const formularioModificar = document.getElementById('formularioModificarReserva'); 
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



//-----------------------------Function to select modify or delete------------------------------------------
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


//-----------------------------Function to show tickets------------------------------------------
document.addEventListener("DOMContentLoaded", () => {
    fetch("/tickets")
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById("tipoEntrada");
            data.forEach(ticket => {
                const option = document.createElement("option");
                option.value = ticket.id;
                option.textContent = ticket.name;
                select.appendChild(option);
            });
        })
        .catch(error => console.error("Error cargando tickets:", error));
});


