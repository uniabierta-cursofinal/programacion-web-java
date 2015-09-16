<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente"%>
<t:page>
 <jsp:attribute name="title">Registrar Cita</jsp:attribute>
 <jsp:body>

<form>
  <div class="form-group">
    <label for="inputFecha">Fecha</label>
    <input type="date" class="form-control" id="inputFecha" name="inputFecha" required>
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
     <label for="inputRazon">Razon:</label>
     <textarea class="form-control" rows="3" name="inputRazon" required></textarea>
   </div>
 
  <div class="row">
			<div class="col-xs-12 col-md-6"><input type="submit" value="Acpetar" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
			<div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/app/index.jsp" class="btn btn-success btn-block btn-lg">Cancelar</a></div> 
	</div>
</form>

</jsp:body>
</t:page>