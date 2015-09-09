<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza"%>
<%


List<Raza> razas = ServicioRaza.getInstancia().getListadoRaza();

%>
<jsp:include page="template/header.jsp"/>

<div class="container">
<form>
  <div class="form-group">
    <label for="inputNombre">Nombre</label>
      <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
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
    <input type="number" class="form-control" id="inputPeso" name="inputPeso" placeholder="Peso">
  </div>
  <div class="form-group">
    <label for="inputFechaNac">Fecha Nacimiento</label>
    <input type="date" class="form-control" id="inputFechaNac" name="inputFechaNac" placeholder="Fecha Nacimiento">
  </div>
  <div class="form-group">
	<label for="inputRaza">Raza:</label>
	<select class="form-control" id="inputRaza" name="inputRaza">
		<c:forEach items="<%=razas%>" var="raza">
              <option value="${raza.getId()}">${pais.getNombre()}</option>        
        </c:forEach>
	 </select>
   </div>
  
  <button type="submit" class="btn btn-default">Aceptar</button>
</form>

<!--</div>-->
 <script src="js/signup.js"></script>
<jsp:include page="template/footer.jsp"/>