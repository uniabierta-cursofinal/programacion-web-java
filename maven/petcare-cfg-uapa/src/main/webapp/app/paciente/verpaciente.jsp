<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza"%>
<t:page>
 <jsp:attribute name="title">Mostrar Paciente</jsp:attribute>
 <jsp:body>
 <c:if test="${!empty mensajeOperacion}">
     <div class="alert alert-info" role="alert">
         <c:out value="${mensajeOperacion}"/>
         <br/>
     </div>
 </c:if>
<form>
  <div class="form-group">
    <label for="inputNombre">Nombre</label>
      <input type="text" class="form-control" id="inputNombre" disabled="disabled" name="inputNombre" placeholder="Nombre">
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
    <input type="number" class="form-control" id="inputPeso" disabled="disabled" name="inputPeso" placeholder="Peso">
  </div>
  <div class="form-group">
    <label for="inputFechaNac">Fecha Nacimiento</label>
    <input type="date" class="form-control" id="inputFechaNac" disabled="disabled" name="inputFechaNac" placeholder="Fecha Nacimiento">
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
            <div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/PacienteController?cmd=edit" class="btn btn-success btn-block btn-lg">Editar Cuenta</a></div>
	</div>
</form>
</jsp:body>
</t:page>