$(document).on("click", ".open-DeleteObject", function () {
	var Data = $(this).data('data');
	var Type = $(this).data('type')
	document.getElementById("Object").innerText = Type + ": " + Data;
})

$(document).on("click",".option", function() {
	var opcion = $(this).data('value')
	console.log(opcion)
	document.getElementById("CursoValue").value = opcion;
})

$(document).on("click",".open-AddUser", function () {

	var curso = $(this).data('curso')

	console.log( curso )

	$( "option" ).each(function( index ) {

		var value = $(this).data('value')

		if ( curso == value ) {
			document.getElementById(curso).setAttribute("selected", "true")
			document.getElementById("CursoValue").value = value;

		}
	});
});