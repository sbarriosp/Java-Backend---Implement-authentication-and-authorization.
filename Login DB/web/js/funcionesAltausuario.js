/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function resetearFormulario(){
    document.getElementById("formularioAlta").reset();
    var avisoContrasena = document.getElementById("avisoContrasena");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");
    
    btnEnviarDatos.disabled = true;
    avisoContrasena.innerHTML = "-------";
    avisoContrasena.style.color = "black";
}

function usuarioGeneradoAutomaticamente(){
    
    var nombre = document.getElementById("txtNombre");
    var apellido = document.getElementById("txtApellido");

    var usuarioGeneradoAutomaticamente = document.getElementById("txtUsuarioGeneradoAutomaticamente");
    
    
    var resultadoCombinado = nombre.value.slice(0,3) + apellido.value.slice (0, 3) + "@dominio.com";
    
    usuarioGeneradoAutomaticamente.value = resultadoCombinado;
    
    if (nombre.value.length == 0 || apellidos.value.length == 0 ) {
        usuarioGeneradoAutomaticamente.value = "";
    }
    
}

function coincidirContrasena() {
    var txtcontrasena = document.getElementById("txtContrasena");
    var txtRepetirContrasena = document.getElementById("txtRepetirContrasena");
    var avisoContrasena = document.getElementById("avisoContrasena");
    var btnEnviarDatos = document.getElementById("btnEnviarDatos");
    
    btnEnviarDatos.disabled = true; //boton inicia desactivado hasta que se llenen los datos
   
    
    if (txtcontrasena.value.length == 0 || txtRepetirContrasena.value.length == 0) {
        avisoContrasena.innerHTML = "Ninguna de las contraseñas coinciden, verifica la información brindada.";
        avisoContrasena.style.color =  "blue";
        btnEnviarDatos.disabled = true;
    }else if (txtContrasena.value != txtRepetirContrasena.value) {
        avisoContrasena.innerHTML = "Las contraseñas son erroneas, no coinciden.";
        avisoContrasena.style.color =  "red";
        btnEnviarDatos.disabled = true;
    }else {
        avisoContrasena.innerHTML = "La contraseña coincide.";
        avisoContrasena.style.color =  "green";
        btnEnviarDatos.disabled = false;
    }
    
}