<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente"%>

 <t:page>
 <jsp:attribute name="title">Pacientes Registrados por cliente</jsp:attribute>
 <jsp:body>
 <div class="row">			
            <div class="col-xs-12 col-md-6"><a href="${pageContext.request.contextPath}/PacienteController?cmd=add" class="btn btn-primary btn-lg">Registrar Paciente</a></div>
	</div>
<br/>
<br/>
<table class="table table-bordered">
 
    <tr><th>#</th><th>Nombre</th><th>Genero</th><th>Raza</th><th>Peso</th><th>Fecha Nacimiento</th></tr>
            <c:forEach items="${pacientes}" var="paciente">
                <tr>
                <td>${paciente.getId()}</td>
                <td>${paciente.getNombre()}</td>
                <td>${paciente.getGenero()}</td>
                <td>${paciente.getRaza().getNombre()}</td>
                <td>${paciente.getPeso()}</td>
                <td>${paciente.getFecha_nacimiento()}</td>
                </tr>        
            </c:forEach>

</table>

</jsp:body>
</t:page>