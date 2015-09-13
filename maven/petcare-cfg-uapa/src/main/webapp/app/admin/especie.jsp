<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie"%>

<%@page import="java.util.List"%>

<t:page>
 <jsp:attribute name="title">Especies Registradas</jsp:attribute>
 <jsp:body>


<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>
            <c:forEach items="${especies}" var="especie">
                <tr><td>${especie.getId()}</td><td>${especie.getNombre()}</td></tr>        
            </c:forEach>
</table>
</jsp:body>
</t:page>