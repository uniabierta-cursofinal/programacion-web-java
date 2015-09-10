<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor"%>

<%

List<Doctor> listadoDoctores = ServicioDoctor.getInstancia().getListadoDoctores();

%>
<jsp:include page="../template/header.jsp"/>
 <h1 class="page-header">Registro de  Doctores</h1>
<form>
  <div class="form-group">
    <label for="inputNombre">Nombre</label>
      <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
  </div>
  <div class="form-group">
    <label for="inputApellido">Apellido</label>
    <input type="text" class="form-control" id="inputApellido" name="inputApellido" placeholder="Apellido">
  </div>
  
  <button type="submit" class="btn btn-default">Aceptar</button>
</form>

<h2 class="sub-header">Doctores Registrados </h2>
<table class="table table-bordered">
 
    <tr><th>#</th><th>Nombre</th><th>Apellido</th></tr>
            <c:forEach items="<%=listadoDoctores%>" var="doctor">
                <tr>
                <td>${doctor.getId()}</td>
                <td>${doctor.getNombre()}</td>
                <td>${doctor.getApellido()}</td>
                </tr>        
            </c:forEach>

</table>
<!--</div>-->
<jsp:include page="../template/footer.jsp"/>