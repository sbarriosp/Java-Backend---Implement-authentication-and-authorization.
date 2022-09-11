/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import SQL.MetodosSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sbarr
 */
public class Iniciosesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession sesion = request.getSession();
            
            MetodosSQL metodos = new MetodosSQL();
            String txtUsuario = request.getParameter("txtUsuario");
            String txtcontrasena = request.getParameter("txtcontrasena");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            
            boolean iniciarsesion = metodos.buscarUsuarioIniciosesion(txtUsuario, txtcontrasena);
            if (iniciarsesion == true){ //el usuario puede accesar porque esta registrado
                out.println("alert('¡Bienvenido! \\nIniciaste sesion como: "+txtUsuario+"')");
                out.println("location = 'paginaInicio.jsp'");

                String Nombre = metodos.buscarNombre(txtUsuario);
                //System.out.println("El valor del nombre en el SERVLET es: "+ nombre);
                sesion.setAttribute("Nombre", Nombre);
                sesion.setAttribute("txtUsuario", txtUsuario);
            }else{
                out.println("alert('Datos Incorrectos, verifica tus credenciales o date de alta en el sistema')");
                out.println("location = 'index.html'");
            }
            System.out.println("El valor de iniciarSesion dentro del SERVLET es: " +iniciarsesion);
            
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

