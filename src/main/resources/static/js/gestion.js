window.addEventListener("keyup", function(){
    obtenerDNI();
})

function obtenerDNI(){
    let dni2 = document.getElementById("dni2")
    dni2.value= document.getElementById("dni").value
}