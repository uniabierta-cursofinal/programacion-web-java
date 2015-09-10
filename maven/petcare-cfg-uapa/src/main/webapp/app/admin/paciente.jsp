<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente"%>

<%

List<Paciente> listadoPacientes = ServicioPaciente.getInstancia().getListadoPacientes();

%>
<jsp:include page="../template/header.jsp"/>
 <h1 class="page-header">Pacientes Registrados</h1>

<table class="table table-bordered">
 
    <tr><th>#</th><th>Nombre</th><th>Genero</th><th>Raza</th><th>Peso</th><th>Fecha Nacimiento</th><th>Dueño</th></tr>
            <c:forEach items="<%=listadoPacientes%>" var="paciente">
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

<jsp:include page="../template/footer.jsp"/>