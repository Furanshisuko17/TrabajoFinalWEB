/**
 * 
 */
 
 function getData(rowId) {
	
	var codigo = document.getElementById(rowId).childNodes[1].innerText
	var nombre = document.getElementById(rowId).childNodes[3].innerText
	var acceso = document.getElementById(rowId).childNodes[5].innerText
	var clave = document.getElementById(rowId).childNodes[7].innerText
	var codigoInput = document.getElementById("idUsuario")
	var nombreInput = document.getElementById("nombre")
	var claveInput = document.getElementById("clave")
	var accesoSelect = document.getElementById("acceso")
	codigoInput.value = codigo
	nombreInput.value = nombre
	claveInput.value = clave
	accesoSelect.value = acceso
	console.log(codigo)
	console.log(nombre)
	console.log(acceso)
	console.log(clave)
	
}