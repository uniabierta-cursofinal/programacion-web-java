<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza"%>
<t:page>
 <jsp:attribute name="title">Editar Paciente</jsp:attribute>
 <jsp:body>
 <c:if test="${!empty mensajeOperacion}">
     <div class="alert alert-warning" role="alert">
         <c:out value="${mensajeOperacion}"/>
         <br/>
     </div>
 </c:if>

     <form method="post" action="${pageContext.request.contextPath}/PacienteController">
  <div class="form-group">
    <label for="inputNombre">Nombre</label>
      <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre" required>
  </div>
  <div class="form-group">
    <label for="inputGenero">Genero</label>
    <select class="form-control" name="inputGenero">
	  <option value="M">Masculino</option>
	  <option value="F">Femenino</option>	  
   </select>
  </div>
   <div class="form-group">
    <label for="inputPeso">Peso</label>
    <input type="number" class="form-control" id="inputPeso" name="inputPeso" placeholder="Peso" required>
  </div>
  <div class="form-group">
    <label for="inputFechaNac">Fecha Nacimiento</label>
    <input type="date" class="form-control" id="inputFechaNac" name="inputFechaNac">
  </div>
  <div class="form-group">
	<label for="inputRaza">Raza:</label>
	<select class="form-control" id="inputRaza" name="inputRaza">
	<c:forEach items="${razas}" var="raza">
              <option value="${raza.getId()}">${raza.getNombre()}</option>        
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