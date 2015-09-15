<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente"%>

 <t:page>
 <jsp:attribute name="title">Cambiar Contraseña</jsp:attribute>
 <jsp:body>
 <c:if test="${!empty mensajeOperacion}">
     <div class="alert alert-info" role="alert">
         <c:out value="${mensajeOperacion}"/>
     </div>
 </c:if>
   	<form role="form" method="post" action="${pageContext.request.contextPath}/ClienteController">
            <input type="hidden" name="id" value="${cliente.getId()}"/>
            <div class="form-group">
			<label for="current_password">Contraseña Actual:</label>
			<input type="password" name="current_password" id="current_password" class="form-control input-lg" placeholder="Contraseña" tabindex="9">
		</div>			
		
	
		<div class="form-group">
			<label for="inputPassword">Nueva Contraseña:</label>
			
                        <input type="password" data-minlength="6" name="inputPassword" id="inputPassword" class="form-control" placeholder="Contraseña" tabindex="9" required>
                        <span class="help-block">Mínimo de 6 caracteres</span>
	       </div>
		
		<div class="form-group">
			<label for="inputConfirmation">Confirmar Contraseña:</label>
			<input type="password" name="password_confirmation" id="password_confirmation" class="form-control" data-match="#inputPassword" data-match-error="uff, contraseña no coinciden" placeholder="Confirmar Contraseña" tabindex="10" required>
                        <div class="help-block with-errors"></div>
		</div>
		
		<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Actualizar" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
				<div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/app/index.jsp" class="btn btn-success btn-block btn-lg">Cancelar</a></div>
		</div>
	</form>
	
</jsp:body>
</t:page>