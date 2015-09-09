<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor"%>
<%


List<Doctor> listadoDoctores = ServicioDoctor.getInstancia().getListadoDoctores();

%>
<jsp:include page="template/header.jsp"/>

<div class="container">
<form>
  <div class="form-group">
    <label for="inputFecha">Fecha</label>
    <input type="date" class="form-control" id="inputFecha" name="inputFecha" disabled="disabled" placeholder="Fecha">
  </div>
  <div class="form-group">
	<label for="inputDoctor">Doctor:</label>
	<select class="form-control" id="inputDoctor" name="inputDoctor">
		<c:forEach items="<%=listadoDoctores%>" var="doctor">
              <option value="${doctor.getId()}">${doctor.getNombre()} ${doctor.getApellido()}</option>        
        </c:forEach>
	 </select>
  </div>
  <div class="form-group">
     <label for="inputDoctor">Razon:</label>
     <textarea class="form-control" rows="3" disabled="disabled" name="inputRazon"></textarea>
   </div>  
</form>

<!--</div>-->
 <script src="js/signup.js"></script>
<jsp:include page="template/footer.jsp"/>