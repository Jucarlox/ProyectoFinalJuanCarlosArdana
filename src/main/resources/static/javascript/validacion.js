let formulario = document.getElementById('formulario');
let inputs = document.querySelectorAll('#formulario input');

let expresiones = {
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	
	correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^\d{7,14}$/ // 7 a 14 numeros.
}

let campos = {
	nombreCliente: false,
	apellidosCliente: false,
	
	
}

let validarFormulario = (e) => {
	switch (e.target.name) {
		case "nombreCliente":
			validarCampo(expresiones.nombre, e.target, 'nombreCliente');
		break;
		case "apellidosCliente":
			validarCampo(expresiones.nombre, e.target, 'apellidosCliente');
		break;
		
		/*
		case "correo":
			validarCampo(expresiones.correo, e.target, 'correo');
		break;
		case "telefono":
			validarCampo(expresiones.telefono, e.target, 'telefono');
		break;*/
	}
}

let validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
		
	} else {
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
}



inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
	
});

document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validar); 
  });


	
	
function validar (evento){
	evento.preventDefault();
   
    let nombreCliente = document.getElementById('nombreCliente').value;
    if (!nombreCliente.match(/^[a-zA-ZÀ-ÿ\s]{1,40}$/) ) {
      document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
      return;
    }
    let apellidosCliente = document.getElementById('apellidosCliente').value;
    if (!apellidosCliente.match(/^[a-zA-ZÀ-ÿ\s]{1,40}$/) ) {
      document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
      return;
    }
    
    
    let terminos = document.getElementById('terminos');
    if (!terminos.checked) {
      document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
      return;
    }
    
    this.submit();
  
};






