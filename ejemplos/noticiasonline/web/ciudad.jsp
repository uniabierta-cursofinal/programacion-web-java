<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cursofinalgrado.uapa.java.servicios.ServicioCiudad"%>
<%@ page import="org.cursofinalgrado.uapa.java.entidades.Ciudad"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="template/header.jsp"/>

<%
    List<Ciudad> ciudades = ServicioCiudad.getInstancia().getListadoCiudades();
   
%>
<h2 class="sub-header">Ciudades</h2>
<table class="table table-striped">
    <tr><th>#</th><th>Nombre</th><th>País</th></tr>    
            <c:forEach items="<%=ciudades%>" var="ciudad">
        <tr><td>${ciudad.getId()}</td><td>${ciudad.getNombre()}</td><td>${ciudad.getPais().getNombre()}</td></tr>

    </c:forEach>
</table>
<a href="agregarciudad.jsp"> Agregar Ciudad</a>


<jsp:include page="template/footer.jsp"/>
