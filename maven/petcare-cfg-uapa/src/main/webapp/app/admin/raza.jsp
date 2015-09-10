<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioEspecie"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza"%>
<%@page import="java.util.List"%>

<%
  List<Raza> razas = ServicioRaza.getInstancia().getListadoRaza();
  
 %>

<jsp:include page="../template/header.jsp"/>
<h1 class="page-header">Razas Registradas</h1>


<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>
            <c:forEach items="<%=razas%>" var="raza">
                <tr><td>${raza.getId()}</td><td>${raza.getNombre()}</td></tr>        
            </c:forEach>
</table>

<jsp:include page="../template/footer.jsp"/>

