<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor"%>

<t:page>
 <jsp:attribute name="title">Registro de  Doctores</jsp:attribute>
 <jsp:body>
 <c:if test="${!empty mensajeOperacion}">
     <div class="alert alert-info" role="alert">
         <c:out value="${mensajeOperacion}"/>
     </div>
 </c:if>
 <form method="post" action="${pageContext.request.contextPath}/AdminController">
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
            <c:forEach items="${doctores}" var="doctor">
                <tr>
                <td>${doctor.getId()}</td>
                <td>${doctor.getNombre()}</td>
                <td>${doctor.getApellido()}</td>
                </tr>        
            </c:forEach>

</table>
</jsp:body>
</t:page>