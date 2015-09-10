<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioEspecie"%>
<%@page import="java.util.List"%>

<%
  List<Especie> especies = ServicioEspecie.getInstancia().getListadoEspecie();
 %>

<jsp:include page="../template/header.jsp"/>
<h1 class="page-header">Especies Registradas</h1>

<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>
            <c:forEach items="<%=especies%>" var="especie">
                <tr><td>${especie.getId()}</td><td>${especie.getNombre()}</td></tr>        
            </c:forEach>
</table>

<jsp:include page="../template/footer.jsp"/>

