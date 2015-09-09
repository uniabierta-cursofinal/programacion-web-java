<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

<jsp:include page="template/header.jsp"/>

<%
  List<Pais> paises = ServicioPais.getInstancia().getListadoPais();
 %>
<div class="container">

   	<form role="form">
		<div class="form-group">
			<label for="current_password">Contrase�a Actual:</label>
			<input type="password" name="current_password" id="current_password" class="form-control input-lg" placeholder="Contrase�a" tabindex="9">
		</div>			
		
	
		<div class="form-group">
			<label for="inputPassword">Nueva Contrase�a:</label>
			<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Contrase�a" tabindex="9">
					
	    </div>
		
		<div class="form-group">
			<label for="inputConfirmation">Confirmar Contrase�a:</label>
			<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirmar Contrase�a" tabindex="10">
		</div>
		
		<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Actualizar" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
				<div class="col-xs-12 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Cancelar</a></div>
		</div>
	</form>
	
 <script src="js/signup.js"></script>
<jsp:include page="template/footer.jsp"/>