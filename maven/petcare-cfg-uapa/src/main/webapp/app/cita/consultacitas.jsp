<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCita"%>

<%
List<Cita> listadoCitas = ServicioCita.getInstancia().getListadoCitas();
%>
<jsp:include page="template/header.jsp"/>

<div class="container">

<table class="table table-bordered">
 
    <tr><th>#</th><th>Fecha</th><th>Doctor</th><th>Razon</th><th></th></tr>
            <c:forEach items="<%=listadoCitas%>" var="cita">
                <tr>
	                <td>${cita.getId()}</td>
	                <td>${cita.getFecha()}</td>
	                <td>${cita.getDoctor().getNombre()} ${cita.getDoctor().getApellido()}</td>
	                <td>${cita.getRazon()}</td>
	                <td><a href="#">Ver Paciente</a></td>              
                </tr>        
            </c:forEach>
</table>
<!--</div>-->
 <script src="js/signup.js"></script>
<jsp:include page="template/footer.jsp"/>