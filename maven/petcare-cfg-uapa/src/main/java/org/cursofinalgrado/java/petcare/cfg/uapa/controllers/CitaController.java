package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.CitaBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCita;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;

/**
 * @author ecabrerar
 * @date Sep 4, 2015
 */
@WebServlet(urlPatterns = { "/CitaController" })
public class CitaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		 String fecha = request.getParameter("inputFecha");

		 String doctorId = request.getParameter("inputDoctor");
		 String pacienteId = request.getParameter("inputPaciente");

		 Optional<Doctor> doctor = ServicioDoctor.getInstancia().getDoctorPorId(Integer.valueOf(doctorId));

		 String razon = request.getParameter("inputRazon");

		 Optional<Paciente> paciente  = ServicioPaciente.getInstancia().getPacientePorId(Integer.valueOf(pacienteId));

		Cita cita = new CitaBuilder()
					     .setRazon(razon)
					     .setDoctor(doctor.get())
					     .setPaciente(paciente.get())
					     .crearCita();

		boolean isCreado = ServicioCita.getInstancia().registrarCita(cita);

		if(isCreado){
			response.sendRedirect("app/cita/consultacitas.jsp");
		}else {
			response.sendRedirect("app/cita/crearcita.jsp");
		}

	}
}
