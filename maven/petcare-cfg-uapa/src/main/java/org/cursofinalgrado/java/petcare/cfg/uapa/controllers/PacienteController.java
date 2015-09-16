package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

    }

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

        String cmd = request.getParameter("cmd");

        List<String> acciones = Arrays.asList("show","edit","add","list");

        if(acciones.contains(cmd)){
                if("list".equals(cmd)){
                    request.setAttribute("pacientes", ServicioPaciente.getInstancia().getListadoPacientes());
                    request.getRequestDispatcher("app/paciente/consultapacientes.jsp").forward(request, response);
                 }

                 if("show".equals(cmd)){
                     request.getRequestDispatcher("app/paciente/verpaciente.jsp").forward(request, response);
                 }

                  request.setAttribute("razas", ServicioRaza.getInstancia().getListadoRaza());

                 if("edit".equals(cmd)){
                     request.getRequestDispatcher("app/paciente/editarpaciente.jsp").forward(request, response);
                 }


                 if("add".equals(cmd)){
                     request.getRequestDispatcher("app/paciente/crearpaciente.jsp").forward(request, response);
                 }

        }
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


}
