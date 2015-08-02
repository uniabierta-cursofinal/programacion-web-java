<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="org.cursofinalgrado.uapa.java.servicios.ServicioCategoria"%>
<%@ page import="org.cursofinalgrado.uapa.java.entidades.Categoria"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="template/header.jsp"/>

<form class="form-horizontal" action="/noticiasonline/CategoriaController" method="post">
    <div class="form-group">
        <label>Nombre</label>
        <input type="text" name="inputDescripcion" style="width:50%;" id="inputNombre" class="form-control" placeholder="Nombre">
    </div>
    
    <div class="form-group">
        <button type="submit" class="btn btn-default" tabindex="3">Confirmar</button>
    </div>

</form>




<jsp:include page="template/footer.jsp"/>