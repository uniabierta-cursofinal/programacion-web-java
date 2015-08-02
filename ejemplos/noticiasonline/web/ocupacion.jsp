<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cursofinalgrado.uapa.java.servicios.ServicioOcupacion"%>
<%@ page import="org.cursofinalgrado.uapa.java.entidades.Ocupacion"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="template/header.jsp"/>

<%
    List<Ocupacion> ocupaciones = ServicioOcupacion.getInstancia().getOcupaciones();
   
%>
<h2 class="sub-header">Ocupaciones</h2>
<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>    
    <c:forEach items="<%=ocupaciones%>" var="ocupacion">
        <tr><td>${categoria.getId()}</td><td>${ocupacion.getDescripcion()}</td>
            <td><a href="editarcategoria.jsp?id=${ocupacion.getId()}">Editar</a></td>
        </tr>

    </c:forEach>
</table>
<a href="agregarcategoria.jsp"> Agregar Ocupacion</a>


<jsp:include page="template/footer.jsp"/>
