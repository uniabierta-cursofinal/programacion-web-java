<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza"%>
<%


List<Raza> razas = ServicioRaza.getInstancia().getListadoRaza();

%>
<jsp:include page="../template/header.jsp"/>
<h1 class="page-header">Mostrar Paciente</h1>

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
		<c:forEach items="<%=razas%>" var="raza">
              <option value="${raza.getId()}">${pais.getNombre()}</option>        
        </c:forEach>
	 </select>
   </div>
</form>

<jsp:include page="../template/footer.jsp"/>