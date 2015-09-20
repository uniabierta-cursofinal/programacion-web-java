package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.correo.ManejadorCorreo;

/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "ContactosController", urlPatterns = {"/ContactosController"})
public class ContactosController extends HttpServlet {

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
        
        String nombre = request.getParameter("inputNombre");
        String correo = request.getParameter("inputEmail");
        String mensaje = request.getParameter("inputMensaje");
        
        if(nombre == null || correo ==null || mensaje==null){
           request.setAttribute("mensajeOperacionError", "Campos en blanco, favor revisar !!");
        }else {
            try {
                ManejadorCorreo.getInstancia().enviarCorreo(nombre, correo, mensaje);
                 request.setAttribute("mensajeOperacionExitoso", "Mensaje enviado !!");
            } catch (MessagingException ex) {
                Logger.getLogger(ContactosController.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensajeOperacionError", ex.getMessage());
            }
        }        
        
         request.getRequestDispatcher("contactos.jsp").forward(request, response); 
        
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
        doPost(request, response);
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
