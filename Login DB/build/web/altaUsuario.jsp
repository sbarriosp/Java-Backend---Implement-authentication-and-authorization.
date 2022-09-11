<%-- 
    Document   : altaUsuario
    Created on : 7 sept. 2022, 11:07:47
    Author     : sbarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="altausuariostyle.css" type="text/css" media="all">
        <% 
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Borrar directivas de memoria cache y anular algoritmos predeterminados para almacenar cache.
            response.setHeader("Pragma", "no-cache"); //Directivas compatibles con memorias cache
            response.setDateHeader("Expires",0); //Proporciona fecha y hora para decir el tiempo de respuesta caduco 
        %>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formularioAlta" id="formularioAlta" method="post" action="GuardarServlet">
                <h1> Registro Usuarios </h1>
                
                <label>Número de Cedula:</label> <input type="text" class="txt" id="txtCedula" required="" name="txtCedula">
                <br>
                <br> 
                <label>Nombre:</label> <input type="text" class="txt" id="txtNombre" required="" onkeyup="usuarioGeneradoAutomaticamente()" name="txtNombre">
                <br>
                <br>
                <label>Apellido:</label> <input type="text" class="txt" id="txtApellido" required="" onkeyup="usuarioGeneradoAutomaticamente()" name="txtApellido"> 
                <br>
                <br>     
                <label>Contraseña:</label> <input type="password" class="txt" id="txtContrasena" required="" onkeyup="coincidirContrasena()"> 
                <label>Repite la contraseña:</label> <input type="password" class="txt" id="txtRepetirContrasena" required="" onkeyup="coincidirContrasena()" name="txtContrasena">                
                <br>
                <br>                          
                <label class="avisoContrasena" id="avisoContrasena">------- </label>
                <br>
                <br> 
                <label>Usuario Generado Automáticamente</label> <input type="text" class="txt" id="txtUsuarioGeneradoAutomaticamente" required="" readonly="" name="txtUsuarioGeneradoAutomaticamente">
                <br>
                <br> 
                
                <input type="submit" value="Enviar Datos" class="btn" id="btnEnviarDatos" disabled="">
                <input type="button" value="Borrar Datos" class="btn" id="btnBorrar" onclick="resetearFormulario()">
            </form>
        </div>
    </body>
    
    <script src="js/funcionesAltausuario.js"> </script>
</html>
