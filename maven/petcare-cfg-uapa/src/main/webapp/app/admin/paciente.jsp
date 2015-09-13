<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>

<t:page>
 <jsp:attribute name="title">Pacientes Registrados</jsp:attribute>
 <jsp:body>


<table class="table table-bordered">
 
    <tr><th>#</th><th>Nombre</th><th>Genero</th><th>Raza</th><th>Peso</th><th>Fecha Nacimiento</th><th>Dueño</th></tr>
            <c:forEach items="${pacientes}" var="paciente">
                <tr>
                <td>${paciente.getId()}</td>
                <td>${paciente.getNombre()}</td>
                <td>${paciente.getGenero()}</td>
                <td>${paciente.getRaza().getNombre()}</td>
                <td>${paciente.getPeso()}</td>
                <td>${paciente.getFecha_nacimiento()}</td>
                <td>${paciente.getCliente().getNombre} ${paciente.getCliente().getApellido()}</td>
                </tr>        
            </c:forEach>

</table>
</jsp:body>
</t:page>