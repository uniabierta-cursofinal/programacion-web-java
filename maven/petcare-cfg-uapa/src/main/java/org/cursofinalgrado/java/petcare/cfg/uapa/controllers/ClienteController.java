package org.cursofinalgrado.java.petcare.cfg.uapa.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.ClienteBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.Util;

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
                String claveActual = request.getParameter("current_password");
                String id = request.getParameter("id");


                 if(id ==null && (nombre == null || apellido==null || usuario ==null 
                     || calle==null || ciudad == null || clave ==null  
                     || pais == null)){
                     
                     response.sendRedirect("signup.jsp");                     
                     
                 } else {
	            
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
                    if(id==null){
                    
                        boolean isCreado = ServicioCliente.getInstancia().registrarCliente(cliente);
                        
                        String pageRedirect = isCreado? "app/index.jsp" : "signup.jsp";                     
                     
                        response.sendRedirect(pageRedirect);
                        
                    } else {
                        cliente.setId(Integer.valueOf(id));
                        boolean isActualizado = false;
                        String pathView;
                        String mensajeOperacion = null;                      
                        
                         Optional<Cliente> clientePorId = ServicioCliente.getInstancia().getClientePorId(Integer.valueOf(id));
                            
                        if(clientePorId.isPresent()){                           
                        
                            if(claveActual==null){
                               isActualizado =  ServicioCliente.getInstancia().editarCliente(cliente);

                               pathView = isActualizado? "app/perfil.jsp" : "app/editarperfil.jsp";  
                               mensajeOperacion = isActualizado? "Perfil actualizado exitosamente" : "No pudo actualizarse el perfil";                           

                            } else {
                            
                                 try {
                                    
                                    if(Util.toMD5(claveActual).equals(clientePorId.get().getClave())){
                                          isActualizado =  ServicioCliente.getInstancia().cambiarContrasena(cliente);
                                          mensajeOperacion = isActualizado? "Contraseña cambiada exitosamente" : "No pudo realizar el cambio de contraseña"; 
                                    } else {
                                        mensajeOperacion = "La clave registrada no coincide con la clave actual digitada";
                                    }
                                } catch (NoSuchAlgorithmException ex) {
                                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                                }            
                                
                                pathView = isActualizado? "app/perfil.jsp" : "app/cambiarcontrasena.jsp";                          
                            }                            
                         
                            request.setAttribute("mensajeOperacion", mensajeOperacion);
                            request.setAttribute("cliente", ServicioCliente.getInstancia().getClientePorId(Integer.valueOf(id)).get());
                            request.getRequestDispatcher(pathView).forward(request, response);                       
                        }                        
                       
                    }
               }
	 }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
            String cmd = request.getParameter("cmd");
            
            List<String> acciones = Arrays.asList("show","edit","chpass");            
            
            if(acciones.contains(cmd)){
                
		 List<Pais> paises = ServicioPais.getInstancia().getListadoPais();
		 HttpSession session = request.getSession();
                 
                 Cliente cliente =  (Cliente) session.getAttribute("currentSessionUser");
                 
                 request.setAttribute("paises", paises);
                 request.setAttribute("cliente", cliente);              
                  
                 if("show".equals(cmd)){
                     request.getRequestDispatcher("app/perfil.jsp").forward(request, response);
                 }
                 
                 if("edit".equals(cmd)){
                     request.getRequestDispatcher("app/editarperfil.jsp").forward(request, response);
                 }
                 
                 
                 if("chpass".equals(cmd)){
                     request.getRequestDispatcher("app/cambiarcontrasena.jsp").forward(request, response);
                 }
                 
                 
		 
            }
            
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

}
