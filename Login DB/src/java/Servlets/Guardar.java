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

/**
 *
 * @author sbarr
 */
public class Guardar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */

        MetodosSQL metodos = new MetodosSQL();
        String txtCedula = request.getParameter("txtCedula");
        String txtNombre = request.getParameter("txtNombre");
        String txtApellido = request.getParameter("txtApellido");
        String txtContrasena = request.getParameter("txtContrasena");
        String txtUsuarioGeneradoAutomaticamente = request.getParameter("txtUsuarioGeneradoAutomaticamente");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<script type=\"text/javascript\">");

        boolean usuarioRepetido = metodos.buscarUsuarioRepertidoBD(txtCedula);
        if (usuarioRepetido == true) { //usuaruo registrado en la bd
            out.println("alert('Atención: El usuario con el número de cédula: " + txtCedula + " está registrado en nuestro sistema.')");
            out.println("location='index.html'");
        } else {
            boolean registro = metodos.registrarUsuario(txtCedula, txtNombre, txtApellido, txtContrasena, txtUsuarioGeneradoAutomaticamente);

            if (registro == true) { //el usuario se ha registrado
                out.println("alert('El usuario se ha registrado exitosamente.')");
                out.println("location='index.html'");
            } else {
                out.println("alert('Error, el usuario no se ha registrado.')");
                out.println("location='index.html'");
            }
        }

        //System.out.println("El valor de registro en SERVLET es: "+ registro);
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
