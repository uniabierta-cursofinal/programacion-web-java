/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cursofinalgrado.uapa.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ecabrerar
 */
@WebServlet(urlPatterns = {"/ServletSubirArchivo"})
@MultipartConfig(location = "/tmp/servlet-cargar-archivo/uploads") //Debe colocar la ruta donde desea colocar la imagen
public class ServletSubirArchivo extends HttpServlet {    
    private final static Logger LOGGER =
            Logger.getLogger(ServletSubirArchivo.class.getCanonicalName());
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         PrintWriter out = response.getWriter();
        
        try  {
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>File Upload Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>File Upload Servlet</h1>");
            out.println("Receiving the uploaded file ...<br>");
            out.println("Received " + request.getParts().size() + " parts ...<br>");
            String fileName = "";
           
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                out.println("... writing " + fileName + " part<br>");
                part.write(fileName);
                out.println("... written<br>");
            }
            out.println("... uploaded to: /tmp/" + fileName);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
     private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
