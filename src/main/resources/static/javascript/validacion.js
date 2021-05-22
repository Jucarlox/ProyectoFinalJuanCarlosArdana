/*$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});
document.forms.formulario
document.getElementById("formulario")
// bindamos al evento submit del elemento formulario la función de validación
document.forms.formulario.addEventListener("submit", function(event){
       let hasError = false;
       nombreCliente = document.getElementById('nombreCliente').value;
   
       if( nombreCliente == null || valor.length == 0) {
         alert('Error, rellena el campo nombreCliente');
         hasError = true;
       }
       apellidosCliente = document.getElementById('apellidosCliente').value;
   
       if( apellidosCliente == null || valor.length == 0) {
         alert('Error, rellena el campo apellidosCliente');
         hasError = true;
       }
       
      fechaReserva = document.getElementById('fechaReserva').value;
      let RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
      if ((fechaReserva.match(RegExPattern)) && (fechaReserva!='')) {
            
      } else {
		alert('Error, rellena el campo fechaReserva');
        hasError = true;
            
      }
        
       if(hasError) event.preventDefault();
   });


function validate(val) {
    v1 = document.getElementById("nombreCliente");
    v2 = document.getElementById("apellidosCliente");
    v3 = document.getElementById("fechaReserva");

    
    flag1 = true;
    flag2 = true;
    flag3 = true;

    
    if(val>=1 || val==0) {
    if(v1.value == "") {
    v1.style.borderColor = "red";
    flag1 = false;
    }
    else {
    v1.style.borderColor = "green";
    flag1 = true;
    }
    }
    
    if(val>=2 || val==0) {
    if(v2.value == "") {
    v2.style.borderColor = "red";
    flag2 = false;
    }
    else {
    v2.style.borderColor = "green";
    flag2 = true;
    }
    }
    if(val>=3 || val==0) {
    if(v3.value == "") {
    v3.style.borderColor = "red";
    flag3 = false;
    }
    else {
    v3.style.borderColor = "green";
    flag3 = true;
    }
    }
    

    
    flag = flag1 && flag2 && flag3;
    
    return flag;
    }
    */
/*function validate(val) {
    v1 = document.getElementById("marca");
    v2 = document.getElementById("modelo");
    v3 = document.getElementById("categoria");
    v4 = document.getElementById("cambio");
    v5 = document.getElementById("consumo");
    v6 = document.getElementById("cv");
    v7 = document.getElementById("co2");
    v8 = document.getElementById("precio");
    v9 = document.getElementById("foto");
    
    flag1 = true;
    flag2 = true;
    flag3 = true;
    flag4 = true;
    flag5 = true;
    flag6 = true;
    flag7 = true;
    flag8 = true;
    flag9 = true;
    
    if(val>=1 || val==0) {
    if(v1.value == "") {
    v1.style.borderColor = "red";
    flag1 = false;
    }
    else {
    v1.style.borderColor = "green";
    flag1 = true;
    }
    }
    
    if(val>=2 || val==0) {
    if(v2.value == "") {
    v2.style.borderColor = "red";
    flag2 = false;
    }
    else {
    v2.style.borderColor = "green";
    flag2 = true;
    }
    }
    if(val>=3 || val==0) {
    if(v3.value == "") {
    v3.style.borderColor = "red";
    flag3 = false;
    }
    else {
    v3.style.borderColor = "green";
    flag3 = true;
    }
    }
    if(val>=4 || val==0) {
    if(v4.value == "") {
    v4.style.borderColor = "red";
    flag4 = false;
    }
    else {
    v4.style.borderColor = "green";
    flag4 = true;
    }
    }
    if(val>=5 || val==0) {
    if(v5.value == "") {
    v5.style.borderColor = "red";
    flag5 = false;
    }
    else {
    v5.style.borderColor = "green";
    flag5 = true;
    }
    }
    if(val>=6 || val==0) {
    if(v6.value == "") {
    v6.style.borderColor = "red";
    flag6 = false;
    }
    else {
    v6.style.borderColor = "green";
    flag6 = true;
    }
    }
    if(val>=7 || val==0) {
    if(v7.value == "") {
    v7.style.borderColor = "red";
    flag7 = false;
    }
    else {
    v7.style.borderColor = "green";
    flag7 = true;
    }
    }
    if(val>=8 || val==0) {
    if(v8.value == "") {
    v8.style.borderColor = "red";
    flag8 = false;
    }
    else {
    v8.style.borderColor = "green";
    flag8 = true;
    }
    }

    
    flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8;
    
    return flag;
    }*/
    
    
    
    
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

