window.addEventListener("load", function(){
    obtSede();
})
window.addEventListener("click", function(){
    obtSede();
})

function obtSede(){
    let sede = document.getElementById("sede");
    
    let cambio = document.getElementById("sed")
    cambio.value= sede.value
}