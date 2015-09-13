package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.DoctorBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCita;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioEspecie;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza;

/**
 * @author ecabrerar
 * @date Sep 4, 2015
 */
@WebServlet(urlPatterns = { "/AdminController" })
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;
        
        private static final String ADMIN_PAGE_DOCTOR    =    "app/admin/doctor.jsp";
        private static final String ADMIN_PAGE_PACIENTE    =    "app/admin/paciente.jsp";
        private static final String ADMIN_PAGE_CLIENTE     =    "app/admin/cliente.jsp";
        private static final String ADMIN_PAGE_CITA        =    "app/admin/cita.jsp";
        private static final String ADMIN_PAGE_ESPECIE      =    "app/admin/especie.jsp";
        private static final String ADMIN_PAGE_PAIS        =     "app/admin/pais.jsp";
        private static final String ADMIN_PAGE_RAZA       =     "app/admin/raza.jsp";        
        

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            
               String cmd = request.getParameter("cmd"); 
               
               
               
               switch(cmd){
                   case "doctor":
                         setInfomacionPagina(request, response, "doctores",
                                 ADMIN_PAGE_DOCTOR, 
                                 ServicioDoctor.getInstancia().getListadoDoctores());
                       break;
                       
                   case "paciente":
                       setInfomacionPagina(request, response, "pacientes",
                               ADMIN_PAGE_PACIENTE, 
                               ServicioPaciente.getInstancia().getListadoPacientes());
                       break;
                       
                   case "cliente":
                       setInfomacionPagina(request, response, "clientes",
                               ADMIN_PAGE_CLIENTE, 
                               ServicioCliente.getInstancia().getListadoClientes());
                       break;
                   case "cita":
                       setInfomacionPagina(request, response, "citas",
                               ADMIN_PAGE_CITA, 
                               ServicioCita.getInstancia().getListadoCitas());
                       break;
                   case "especie":
                       setInfomacionPagina(request, response, "especies",
                               ADMIN_PAGE_ESPECIE, 
                               ServicioEspecie.getInstancia().getListadoEspecie());
                       break;
                   case "pais":
                       setInfomacionPagina(request, response, "paises",
                               ADMIN_PAGE_PAIS, 
                               ServicioPais.getInstancia().getListadoPais());
                       break;
                   case "raza":
                       setInfomacionPagina(request, response, "razas",
                               ADMIN_PAGE_RAZA, 
                                ServicioRaza.getInstancia().getListadoRaza());
                       break;
                   default:
                           
               }                
                
	}
        
        
        private <T> void setInfomacionPagina(HttpServletRequest request,
			HttpServletResponse response, String atributo, String pagina, List<T> atributoValor ) throws ServletException, IOException{
                  
		   request.setAttribute(atributo, atributoValor);
                   request.getRequestDispatcher(pagina).forward(request, response);
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
