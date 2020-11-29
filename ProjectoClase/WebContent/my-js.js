$(document).on("click", ".open-DeleteObject", function () {
	var Data = $(this).data('data');
	var Type = $(this).data('type')
	document.getElementById("Object").innerText = Type + ": " + Data;
	document.getElementById("Key").value = Data;
	document.getElementById("op").value = "delete" + Type;
	
})

$(document).on("click",".option", function() {
	var opcion = $(this).data('value')
	document.getElementById("CursoValue").value = opcion;
})

$(document).on("click",".open-AddUser", function () {

	var metodo = $(this).data('metodo')
	var curso = $(this).data('curso')

	var alumnodni = $(this).data('dni')
	var alumnonombre = $(this).data('nombre')

	if (metodo == "add") {

		document.getElementById("AddUserLabel").innerText = "Añadir usuario";

		document.getElementById("DNI").value = "";
		document.getElementById("DNI").removeAttribute("readonly", "true")
		document.getElementById("Nombre").value = "";

		$( "option" ).each(function( index ) {
	

			var value = $(this).data('value')
	
			if ( curso == value ) {
				document.getElementById(curso).setAttribute("selected", "true")
				document.getElementById("CursoValue").value = value;

				
	
			}
		})

		document.getElementById("opAddAlumno").value = "addAlumno";

	}else if(metodo == "edit") {

		document.getElementById("AddUserLabel").innerText = "Editar usuario";

		document.getElementById("DNI").value = alumnodni;
		document.getElementById("DNI").setAttribute("readonly", "true")
		document.getElementById("Nombre").value = alumnonombre;

		$( "option" ).each(function( index ) {
	

			var value = $(this).data('value')
	
			if ( curso == value ) {
				document.getElementById(curso).setAttribute("selected", "true")
				document.getElementById("CursoValue").value = value;
	
			}
		})

		document.getElementById("opAddAlumno").value = "editAlumno";

	}

	
})

$(document).on("click", ".open-AddEmail", function () {
	var dniEmail = $(this).data('dniemail')
	var nombre = $(this).data('nombre')
	document.getElementById("AddEmailTitle").innerText = "Añadir email a " + nombre
	document.getElementById("dniEmail").value = dniEmail
}) 

$(document).on("click", ".open-AddPhone", function () {
	var dniPhone = $(this).data('dniphone')
	var nombre = $(this).data('nombre')
	document.getElementById("AddPhoneTitle").innerText = "Añadir telefono a " + nombre
	document.getElementById("dniPhone").value = dniPhone
}) 