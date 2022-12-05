window.addEventListener("click", function(){
    obtenerDNI();
    obtenerDNI2();
})

window.addEventListener("click", function(){
    obtenerSEDE();
})

function obtenerDNI(){
    let dni2 = document.getElementById("dni2")
    dni2.value= document.getElementById("dni").value
}

function obtenerDNI2(){
    let dni3 = document.getElementById("dni3")
    dni3.value= document.getElementById("dni").value
}

function obtenerSEDE(){
    let idsede = document.getElementById("idsede")
    idsede.value= document.getElementById("sede").value
}
