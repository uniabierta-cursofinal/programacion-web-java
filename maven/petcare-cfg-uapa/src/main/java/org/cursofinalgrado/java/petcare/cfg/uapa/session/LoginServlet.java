package org.cursofinalgrado.java.petcare.cfg.uapa.session;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCliente;


/**
 *
 * @author ecabrerar
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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

      String usuario = request.getParameter("usuario");
      String pass = request.getParameter("pass");

      //Hacer una consulta a la base de datos para determinar si el usuario esta registrado
      Optional<Cliente> opCliente = ServicioCliente.getInstancia().validarCliente(usuario, pass);

       HttpSession session = request.getSession();

       if(opCliente.isPresent() && opCliente.get() instanceof Cliente){

    	 //guardar el usuario en session
            session.setAttribute("currentSessionUser",opCliente.get());

            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);

            Cookie userName = new Cookie("user", usuario);
            userName.setMaxAge(30*60);

            response.addCookie(userName);
            response.sendRedirect("app/index.jsp");

        }else{

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

            //Enviando mensaje a la pagina de login
             session.setAttribute("loginFailed","Usuario no registrado");
             response.sendRedirect("index.jsp");

             rd.include(request, response);
        }
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
    }

}
