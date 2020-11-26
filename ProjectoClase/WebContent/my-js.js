$(document).on("click", ".open-DeleteObject", function () {
	var Data = $(this).data('data');
	var Type = $(this).data('type')
	document.getElementById("Object").innerText = Type + ": " + Data;
})