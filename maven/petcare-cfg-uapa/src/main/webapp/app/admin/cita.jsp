<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>

<t:page>
 <jsp:attribute name="title">Citas Registradas</jsp:attribute>
 <jsp:body>


<table class="table table-bordered">
 
    <tr><th>#</th><th>Fecha</th><th>Doctor</th><th>Razon</th><th></th></tr>
            <c:forEach items="${citas}" var="cita">
                <tr>
	                <td>${cita.getId()}</td>
	                <td>${cita.getFecha()}</td>
	                <td>${cita.getDoctor().getNombre()} ${cita.getDoctor().getApellido()}</td>
	                <td>${cita.getRazon()}</td>
	                <td><a href="#">Ver Paciente</a></td>              
                </tr>        
            </c:forEach>
</table>
</jsp:body>
</t:page>