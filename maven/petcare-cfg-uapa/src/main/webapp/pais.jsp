<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

<%
  List<Pais> paises = ServicioPais.getInstancia().getListadoPais();
 %>

<jsp:include page="template/header.jsp"/>
<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>
            <c:forEach items="<%=paises%>" var="pais">
         <tr><td>${pais.getId()}</td><td>${pais.getDescripcion()}</td></tr>
        
            </c:forEach>
</table>

<jsp:include page="template/footer.jsp"/>

