<%-- 
    Document   : paginaInicio
    Created on : 8 sept. 2022, 14:50:29
    Author     : sbarr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/pantallainiciostyle.css"/>
        <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        
        if(session.getAttribute("txtUsuario") == null && session.getAttribute("Nombre") == null){
            response.sendRedirect("index.html");
        }
        %>
        
    </head>
    <body>
        <h1>¡Hola <%=request.getSession().getAttribute("Nombre")%>!, !Bienvenido/a¡ </h1>
        
        <p><a href="https://www.google.com"> Ir a Google </a> </p>
        <p> Actualmente en uso: ${txtUsuario} </p>
        
        <form action="CerrarSesionServlet"> 
            <input type="submit" value="Cerrar Sesión">
        </form>
    </body>
</html>
