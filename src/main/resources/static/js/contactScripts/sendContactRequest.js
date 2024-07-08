function validarFormularioContacto(event) {
    event.preventDefault(); // Evitar que el evento por defecto se ejecute

    var form = document.getElementById('form-contact');
    var inputs = form.getElementsByTagName('input');
    var mensajeContainer = document.getElementById('texto_error');

    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        if (input.value.trim() === '') {
            var mensaje = "Por favor, completa todos los campos.";
            mostrarMensaje(mensaje, mensajeContainer);
            return false; // Detener la validación y no enviar el formulario
        }
    }

    return true;
}

function mostrarMensaje(mensaje, container) {
    container.innerHTML = mensaje;
}

function validarEnvioFormularioContacto() {

    var contactForm = document.querySelector('.form-contact');
    contactForm.addEventListener('submit', function (event) {
        event.preventDefault();
        if (validarFormularioContacto(event)) {
                    // Realizar una petición AJAX o enviar el formulario de forma asíncrona
                    //alert("Si llega aqui.");
                    fetch(contactForm.action, {
                        method: 'POST',
                        body: new FormData(contactForm )
                    })
                        .then(response => response.json())
                        .then(data => {
                            if (data.success) {
                                // Si el proceso de agregar el cliente fue exitoso, mostrar mensaje de éxito
                                mostrarToastConfirmacion(data.message);
                                // Redirigir después de un pequeño retraso
                                setTimeout(function () {
                                    window.location.href = '/contact';
                                }, 5000); // 1000 milisegundos de retraso
                            } else {
                                // Si el proceso de agregar el cliente falló, mostrar mensaje de error
                                mostrarToastError(data.message);
                            }
                        })
                        .catch(error => {
                            console.error('Error:', error);
                        });
        }
    });
}

// Función para mostrar un Toast de error
function mostrarToastError(mensaje) {
    const Toast = Swal.mixin({
        toast: true,
        position: 'bottom-end',
        showConfirmButton: false,
        timer: 5000
    });
    Toast.fire({
        icon: 'error',
        title: mensaje
    });
}

// Función para mostrar un Toast de confirmación
function mostrarToastConfirmacion(titulo) {
    const Toast = Swal.mixin({
        toast: true,
        //position: 'bottom-end',
        showConfirmButton: false,
        timer: 5000
    });
    Toast.fire({
        icon: 'success',
        title: titulo
    });
}