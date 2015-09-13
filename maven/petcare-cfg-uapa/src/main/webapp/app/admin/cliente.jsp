<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente"%>
<%@page import="java.util.List"%>

<t:page>
 <jsp:attribute name="title">Clientes Registrados</jsp:attribute>
 <jsp:body>
 

<table class="table table-striped">
    <tr><th>#</th><th>Nombre</th><th>Apellido</th><th>Usuario</th></tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                <td>${cliente.getId()}</td>
                <td>${cliente.getNombre()}</td>
                <td>${cliente.getApellido()}</td>
                <td>${cliente.getUsuario()}</td>
                </tr>        
            </c:forEach>
</table>
</jsp:body>
</t:page>