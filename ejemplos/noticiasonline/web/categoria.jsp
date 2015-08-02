<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cursofinalgrado.uapa.java.servicios.ServicioCategoria"%>
<%@ page import="org.cursofinalgrado.uapa.java.entidades.Categoria"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="template/header.jsp"/>

<%
    List<Categoria> categorias = ServicioCategoria.getInstancia().getListadoCategorias();
   
%>
<h2 class="sub-header">Categorias</h2>
<table class="table table-striped">
    <tr><th>#</th><th>Descripcion</th></tr>    
            <c:forEach items="<%=categorias%>" var="categoria">
        <tr><td>${categoria.getId()}</td><td>${categoria.getDescripcion()}</td>
            <td><a href="editarcategoria.jsp?id=${categoria.getId()}">Editar</a></td>
        </tr>

    </c:forEach>
</table>
<a href="agregarcategoria.jsp"> Agregar categoria</a>


<jsp:include page="template/footer.jsp"/>
