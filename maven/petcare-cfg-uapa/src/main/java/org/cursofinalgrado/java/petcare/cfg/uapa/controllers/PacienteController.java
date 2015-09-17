package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.PacienteBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza;

import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/PacienteController"})
public class PacienteController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String mensajeOperacion;

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
                String fecha = request.getParameter("inputFechaNac");

                String id = request.getParameter("id");
                String peso = request.getParameter("inputPeso");
                String genero = request.getParameter("inputGenero");
                String raza = request.getParameter("inputRaza");
                
                 boolean isCreado = false;
                
                 HttpSession session = request.getSession();
                 
                 Cliente cliente =  (Cliente) session.getAttribute("currentSessionUser");
                 
                  request.setAttribute("razas", ServicioRaza.getInstancia().getListadoRaza());
                 
                 if(id==null && (nombre==null || fecha==null || peso==null || genero==null || raza ==null || cliente==null)){
            
                        mensajeOperacion  = "Campos en blanco";         
                 }else {
                     
                    Optional<Raza> razaPorId = ServicioRaza.getInstancia().getRazaPorId(Integer.valueOf(raza));
                     
                     Paciente paciente = new PacienteBuilder()
                                         .setCliente(cliente)
                                         .setNombre(nombre)
                                         .setGenero(genero)                                        
                                         .setPeso(Integer.valueOf(peso))
                                         .setRaza(razaPorId.get())
                                         .setFechaNacimiento(LocalDate.parse(fecha))
                                         .crearPaciente();
                     
                    isCreado = ServicioPaciente.getInstancia().crearPaciente(paciente);
                     
                  mensajeOperacion = isCreado? "Registro agregado exitosamente":"No se pudo agregar el registro";
   
        }
            
         String pathView = isCreado?"app/paciente/consultapacientes.jsp":"app/paciente/crearpaciente.jsp";
         request.setAttribute("mensajeOperacion", mensajeOperacion);
         request.setAttribute("pacientes", ServicioPaciente.getInstancia().getListadoPacientes());
         request.getRequestDispatcher(pathView).forward(request, response); 


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
