<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

 <t:page>
 <jsp:attribute name="title">Mi Cuenta</jsp:attribute>
 <jsp:body>
    <c:if test="${!empty mensajeOperacion}">
        <div class="alert alert-info" role="alert">
            <c:out value="${mensajeOperacion}"/>
        </div>
    </c:if>
	<form role="form">			

		<div class="form-group">
		    <label>Nombre:</label>
                    <input type="text" name="nombre" id="nombre" disabled="disabled" class="form-control input-lg" value="${cliente.getNombre()}" tabindex="1">
		</div>
	
		<div class="form-group">
		  <label>Apellido:</label>
			<input type="text" name="apellido" id="apellido" disabled="disabled" class="form-control input-lg" value="${cliente.getApellido()}" tabindex="2">
		</div>

		<div class="form-group">
		    <label>Usuario:</label>
			<input type="text" name="usuario" id="usuario" disabled="disabled" class="form-control input-lg" value="${cliente.getUsuario()}" tabindex="3">
		</div>
		<div class="form-group">
		   <label>Telefono:</label>
			<input type="tel" name="telefono" id="telefono" disabled="disabled" class="form-control input-lg" value="${cliente.getTelefono()}" tabindex="4">
		</div>
		
		<div class="form-group">
		    <label>Calle:</label>
           <input type="text" name="calle" id="calle" disabled="disabled" class="form-control input-lg" value="${cliente.getCalle()}" tabindex="5">
	   </div>
	
		<div class="form-group">
		  <label>Apartamento:</label>
			<input type="text" name="apt" id="apt" disabled="disabled" class="form-control input-lg" value="${cliente.getApartamento()}" tabindex="6">
	  </div>
	  <div class="form-group">
	 	<label>Ciudad:</label>
		<input type="text" name="ciudad" id="ciudad" disabled="disabled" class="form-control input-lg" value="${cliente.getCiudad()}" tabindex="7">
	  </div>
	   <div class="form-group">
			  <label for="pais">País:</label>
			  <input type="text" name="pais" id="pais" disabled="disabled" class="form-control input-lg" value="${cliente.getPais().getDescripcion()}" tabindex="8">
            </div>		
		
	<div class="row">			
            <div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/ClienteController?cmd=edit" class="btn btn-success btn-block btn-lg">Editar Cuenta</a></div>
	</div>
	</form>
</jsp:body>
</t:page>