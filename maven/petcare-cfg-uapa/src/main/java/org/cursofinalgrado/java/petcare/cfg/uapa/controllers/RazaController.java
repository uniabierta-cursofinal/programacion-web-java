/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.EspecieBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.RazaBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "RazaController", urlPatterns = {"/RazaController"})
public class RazaController extends HttpServlet {

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
        
       String nombre = request.getParameter("nombre");
       String especieParam  = request.getParameter("especie");
       
       if(null!=especieParam){
           
           Especie  especie = new EspecieBuilder()
                                    .setId(Integer.valueOf(especieParam))
                                    .crearEspecie();          
           
           Raza raza = new RazaBuilder()
                            .setNombre(nombre)
                            .setEspecie(especie)
                            .crearRaza();
                   
           
           
//          boolean estado = ServicioRaza.getInstancia().crearRaza(raza);
//          
//          if(estado){
//              response.sendRedirect("raza.jsp");
//          }
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
