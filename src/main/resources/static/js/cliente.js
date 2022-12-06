window.addEventListener("click", function(){
    obtenerPLAN();
    obtenerSEDE();
})

function obtenerPLAN(){
    let planb1 = document.getElementById("planb1")
    planb1.value= document.getElementById("plan").value

    let planb3 = document.getElementById("planb3")
    planb3.value= document.getElementById("plan").value
}

function obtenerSEDE(){
    let sedeb2 = document.getElementById("sedeb2")
    sedeb2.value= document.getElementById("sede").value

    let sedeb3 = document.getElementById("sedeb3")
    sedeb3.value= document.getElementById("sede").value
}