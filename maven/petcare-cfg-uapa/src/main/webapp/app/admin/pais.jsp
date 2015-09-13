<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>

<t:page>
 <jsp:attribute name="title">Listado de Paises</jsp:attribute>
 <jsp:body>


<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>
            <c:forEach items="${paises}" var="pais">
         <tr><td>${pais.getId()}</td><td>${pais.getDescripcion()}</td></tr>
        
            </c:forEach>
</table>

</jsp:body>
</t:page>

