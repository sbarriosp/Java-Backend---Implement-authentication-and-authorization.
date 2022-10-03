<%-- 
    Document   : login
    Created on : 9 sept. 2022, 15:39:23
    Author     : sbarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/loginstyle.css"/>
    </head>
    
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formularioLogin" id="formularioLogin" method="post" action="IniciosesionServlet">
                <h1>Inicie Sesion</h1>

                <p>Usuario:</p>
                <div class="texto">
                    <input type="text" class="txt" id="txtUsuario" required="" name="txtUsuario">
                </div>

                <p>Contraseña:</p>
                <div class="texto">
                    <input type="password" class="txt" id="txtcontrasena" required="" name="txtcontrasena">
                </div>

                <br>

                <input type="submit" value="Iniciar Sesion" class="btn">
                <input type="button" value="Borrar Datos" class="btn" onclick="resetearFormularioLogin()">

            </form>
        </div>
    </body>
    <script src="js/funcionesLogin.js"></script>
</html>
