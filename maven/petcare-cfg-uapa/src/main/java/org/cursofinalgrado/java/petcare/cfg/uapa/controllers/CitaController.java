package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.CitaBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCita;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;

/**
 * @author ecabrerar
 * @date Sep 4, 2015
 */
@WebServlet(urlPatterns = {"/CitaController"})
public class CitaController extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String cmd = request.getParameter("cmd");

        List<String> acciones = Arrays.asList("show","edit","add","list");
        
        String id = request.getParameter("id");
 
        if(acciones.contains(cmd)){

                if("list".equals(cmd)){
                     request.setAttribute("citas", ServicioCita.getInstancia().getListadoCitas());
                     request.getRequestDispatcher("app/cita/consultacitas.jsp").forward(request, response);
                 }
                
                
                request.setAttribute("doctores", ServicioDoctor.getInstancia().getListadoDoctores());
                request.setAttribute("pacientes", ServicioPaciente.getInstancia().getListadoPacientes());
                
                if("add".equals(cmd)){
                    request.getRequestDispatcher("app/cita/crearcita.jsp").forward(request, response);
                }
                
                if(null !=id){
                    
                    Optional<Cita> citaPorId = ServicioCita.getInstancia().getCitaPorId(Integer.parseInt(id));
                    
                    if(citaPorId.isPresent()){
                      request.setAttribute("cita", citaPorId.get());
                    }
                    
                    if("edit".equals(cmd)){
                        request.getRequestDispatcher("app/cita/editarcita.jsp").forward(request, response);
                    }

                    if("show".equals(cmd)){
                     request.getRequestDispatcher("app/cita/vercita.jsp").forward(request, response);
                    }
                    
                }


        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String fecha = request.getParameter("inputFecha");
        String id = request.getParameter("id");

        String doctorId = request.getParameter("inputDoctor");
        String pacienteId = request.getParameter("inputPaciente");

        Optional<Doctor> doctor = ServicioDoctor.getInstancia().getDoctorPorId(Integer.valueOf(doctorId));

        String razon = request.getParameter("inputRazon");

        Optional<Paciente> paciente = ServicioPaciente.getInstancia().getPacientePorId(Integer.valueOf(pacienteId));

        String mensajeOperacion;
        String pathView;
        boolean isCreado = false;

        if(id==null && (fecha==null || doctorId==null || pacienteId==null || razon ==null)){

           mensajeOperacion  = "Campos en blanco";
        } else {

                Cita cita = new CitaBuilder()
                       .setRazon(razon)
                       .setDoctor(doctor.get())
                       .setPaciente(paciente.get())
                       .setFecha(LocalDateTime.parse(fecha))
                       .crearCita();

               isCreado = ServicioCita.getInstancia().registrarCita(cita);
               mensajeOperacion = isCreado? "Registro agregado exitosamente":"No se pudo agregar el registro";

        }

         pathView =   isCreado?"app/cita/consultacitas.jsp":"app/cita/crearcita.jsp";
         request.setAttribute("mensajeOperacion", mensajeOperacion);
         request.setAttribute("citas", ServicioCita.getInstancia().getListadoCitas());
         request.getRequestDispatcher(pathView).forward(request, response);


    }
}
