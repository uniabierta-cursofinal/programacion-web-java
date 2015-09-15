<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

 <t:page>
 <jsp:attribute name="title">Editar información de cuenta</jsp:attribute>
 <jsp:body>
  
 <c:if test="${!empty mensajeOperacion}">
     <div class="alert alert-info" role="alert">
         <c:out value="${mensajeOperacion}"/>
     </div>
 </c:if>
 
	<form role="form" method="post" action="${pageContext.request.contextPath}/ClienteController">			
            <input type="hidden" name="id" value="${cliente.getId()}"/>
		<div class="form-group">
		    <label>Nombre:</label>
            <input type="text" name="inputNombre" id="inputNombre"  class="form-control input-lg" value="${cliente.getNombre()}" tabindex="1" required>
		</div>
	
		<div class="form-group">
		  <label>Apellido:</label>
			<input type="text" name="inputApellido" id="inputApellido"  class="form-control input-lg" value="${cliente.getApellido()}" tabindex="2" required>
		</div>

		<div class="form-group">
		    <label>Usuario:</label>
			<input type="text" name="inputUsuario" id="inputUsuario" disabled="disabled"  class="form-control input-lg" value="${cliente.getUsuario()}" tabindex="3" required>
		</div>
		<div class="form-group">
		   <label>Telefono:</label>
			<input type="tel" name="inputTelefono" id="inputTelefono"  class="form-control input-lg" value="${cliente.getTelefono()}" tabindex="4">
		</div>
		
		<div class="form-group">
		    <label>Telefono:</label>
                    <input type="text" name="inputCalle" id="inputCalle"  class="form-control input-lg" value="${cliente.getCalle()}" tabindex="5" required>
                </div>
	
		<div class="form-group">
		  <label>Apartamento:</label>
			<input type="text" name="inputApt" id="inputApt"  class="form-control input-lg" value="${cliente.getApartamento()}" tabindex="6">
                </div>
	  <div class="form-group">
	 	<label>Ciudad:</label>
		<input type="text" name="inputCiudad" id="inputCiudad"  class="form-control input-lg" value="${cliente.getCiudad()}" tabindex="7" required>
	  </div>
	   <div class="form-group">
			  <label for="pais">País:</label>
			  <select class="form-control" id="inputPais" name="inputPais" tabindex="8">
			     <c:forEach items="${paises}" var="pais">
                                <option value="${pais.getId()}" <c:if test="${pais.getId()}==${cliente.getPais().getId()}"> selected</c:if>>${pais.getDescripcion()}</option>        
                             </c:forEach>
			  </select>
     </div>		
		
	<div class="row">
			<div class="col-xs-12 col-md-6"><input type="submit" value="Actualizar" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
			<div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/app/index.jsp" class="btn btn-success btn-block btn-lg">Cancelar</a></div> 
	</div>
	</form>

</jsp:body>
</t:page>