window.addEventListener("click", function(){
    obtenerTODO();
})

function obtenerTODO(){

    let planfiltrar = document.getElementById("planfiltrar")
    planfiltrar.value= document.getElementById("plan").value

    let sedefiltrar = document.getElementById("sedefiltrar")
    sedefiltrar.value= document.getElementById("sede").value

    let estadofiltrar = document.getElementById("estadofiltrar")
    estadofiltrar.value= document.getElementById("estado").value
}