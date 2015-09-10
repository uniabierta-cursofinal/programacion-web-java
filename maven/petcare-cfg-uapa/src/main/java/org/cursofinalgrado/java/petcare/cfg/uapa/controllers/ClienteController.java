package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.ClienteBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais;

/**
 * @author ecabrerar
 * @date Sep 4, 2015
 */
@WebServlet(urlPatterns = { "/ClienteController" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String nombre = request.getParameter("inputNombre");
	        String apellido = request.getParameter("inputApellido");
	        String usuario = request.getParameter("inputUsuario");
	        String telefono = request.getParameter("inputTelefono");
	        String calle = request.getParameter("inputCalle");
	        String apt = request.getParameter("inputApt");
	        String ciudad = request.getParameter("inputCiudad");
	        String pais = request.getParameter("inputPais");

	        String clave = request.getParameter("inputPassword");

	        Optional<Pais> paisOptional =  ServicioPais.getInstancia().getPaisPorId(Integer.valueOf(pais));


	     Cliente cliente =  new ClienteBuilder()
	                    .setNombre(nombre)
	                    .setApellido(apellido)
	                    .setUsuario(usuario)
	                    .setTelefono(telefono)
	                    .setCalle(calle)
	                    .setApartamento(apt)
	                    .setCiudad(ciudad)
	                    .setPais(paisOptional.get())
	                    .setClave(clave)
	                    .crearCliente();

	     boolean isCreado = ServicioCliente.getInstancia().registrarCliente(cliente);

	     if(isCreado){
	    	 response.sendRedirect("index.jsp");
	     } else {
	    	 response.sendRedirect("signup.jsp");
	     }

	 }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

}
