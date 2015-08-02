<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.cursofinalgrado.uapa.java.servios.ServicioCategoria"%>
<%@ page import="org.cursofinalgrado.uapa.java.entidades.Categoria"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="template/header.jsp"/>
<%
    int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria=null;

        if (id > 0) {

            categoria = ServicioCategoria.getInstancia().getCategoriaPorId(id);

        } else {
            response.sendError(404, "No encontrado");
        }
    
    %>

<form class="form-horizontal" action="/noticiasonline/CategoriaController" method="post">
    <input type="hidden" name="idCategoria" value="<%=categoria.getId()%>"/>
           
    <div class="form-group">
        <label>Nombre</label>
        <input type="text" name="inputDescripcion" style="width:50%;" id="inputNombre" class="form-control" placeholder="Nombre" value="<%=categoria.getDescripcion()%>">
    </div>
    
    <div class="form-group">
        <button type="submit" class="btn btn-default" tabindex="3">Confirmar</button>
    </div>

</form>




<jsp:include page="template/footer.jsp"/>