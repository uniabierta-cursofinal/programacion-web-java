<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor"%>
<t:page>
 <jsp:attribute name="title">Mostrar Cita</jsp:attribute>
 <jsp:body>

<form>
  <div class="form-group">
    <label for="inputFecha">Fecha</label>
    <input type="date" class="form-control" id="inputFecha" name="inputFecha" disabled="disabled">
  </div>
  <div class="form-group">
	<label for="inputDoctor">Doctor:</label>
	<select class="form-control" id="inputDoctor" name="inputDoctor">
		<c:forEach items="${doctores}" var="doctor">
              <option value="${doctor.getId()}">${doctor.getNombre()} ${doctor.getApellido()}</option>        
        </c:forEach>
	 </select>
  </div>
        <div class="form-group">
	<label for="inputPaciente">Paciente:</label>
	<select class="form-control" id="inputPaciente" name="inputPaciente">
		<c:forEach items="${pacientes}" var="paciente">
              <option value="${paciente.getId()}">${paciente.getNombre()}</option>        
        </c:forEach>
	 </select>
  </div>
  <div class="form-group">
     <label for="inputDoctor">Razon:</label>
     <textarea class="form-control" rows="3" disabled="disabled" name="inputRazon"></textarea>
   </div>  
</form>


</jsp:body>
</t:page>