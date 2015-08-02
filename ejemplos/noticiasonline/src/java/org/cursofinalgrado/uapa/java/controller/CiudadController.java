/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cursofinalgrado.uapa.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cursofinalgrado.uapa.java.entidades.Ciudad;
import org.cursofinalgrado.uapa.java.entidades.Pais;
import org.cursofinalgrado.uapa.java.servicios.ServicioCiudad;
import org.cursofinalgrado.uapa.java.servicios.ServicioPais;

/**
 *
 * @author ecabrerar
 */
public class CiudadController extends HttpServlet {

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
       
        String nombre = request.getParameter("inputNombre");
        String inputPais = request.getParameter("inputPais");

        Pais pais =  ServicioPais.getInstancia().getPaisPorId(Integer.valueOf(inputPais));
        
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        ciudad.setPais(pais);
        
        boolean isCreado = ServicioCiudad.getInstancia().crearCiudad(ciudad);

        if (isCreado) {

            response.sendRedirect("ciudad.jsp");

        } else {

            response.sendRedirect("agregarciudad.jsp");

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
