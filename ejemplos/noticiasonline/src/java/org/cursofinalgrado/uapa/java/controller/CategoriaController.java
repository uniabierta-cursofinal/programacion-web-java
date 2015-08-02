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
import org.cursofinalgrado.uapa.java.entidades.Categoria;
import org.cursofinalgrado.uapa.java.servicios.ServicioCategoria;

/**
 *
 * @author ecabrerar
 */
public class CategoriaController extends HttpServlet {

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

        String descripcion = request.getParameter("inputDescripcion");
        String idCategoria = request.getParameter("idCategoria");       
      
        
        if(null!=idCategoria){
              Categoria cat = new Categoria();
              cat.setId(Integer.parseInt(idCategoria));
              cat.setDescripcion(descripcion);
              
              boolean isActualizado = ServicioCategoria.getInstancia().actualizarCategoria(cat);
              
              if (isActualizado) {
                  response.sendRedirect("categoria.jsp");

            } else {
                response.sendRedirect("editarcategoria.jsp");

            }
              
        } else {
        
        Categoria cat = new Categoria();
        cat.setDescripcion(descripcion);
        boolean isCreado = ServicioCategoria.getInstancia().crearCategoria(cat);

        if (isCreado) {
            response.sendRedirect("categoria.jsp");

        } else {
            response.sendRedirect("agregarcategoria.jsp");

        }
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
