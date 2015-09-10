package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.DoctorBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor;

/**
 * @author ecabrerar
 * @date Sep 4, 2015
 */
@WebServlet(urlPatterns = { "/DoctorController" })
public class DoctorController extends HttpServlet {

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

		 String nombre = request.getParameter("inputNombre");
	     String apellido = request.getParameter("inputApellido");

	    Doctor doctor =   new DoctorBuilder()
					     	.setNombre(nombre)
					     	.setApellido(apellido)
					     	.crearDoctor();

	    ServicioDoctor.getInstancia().registrarDoctor(doctor);


	    response.sendRedirect("admin/doctor.jsp");


	}

}
