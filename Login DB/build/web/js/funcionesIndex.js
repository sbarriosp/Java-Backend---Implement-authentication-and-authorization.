/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 * contendra 3 metodos function que caarga elemento dinamicamente, 
 */

function cargarElementoDinamicamente(url, elemento) {
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText; 
}

function cargarAltaUsuario(){
    cargarElementoDinamicamente("altaUsuario.jsp", document.getElementById("contenidoDinamico"));    
}

function cargarLogin(){
    cargarElementoDinamicamente("login.jsp", document.getElementById("contenidoDinamico"));
}


