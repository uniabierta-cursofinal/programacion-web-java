<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais"%>
<%@page import="org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais"%>

<jsp:include page="template/header.jsp"/>

<%
  List<Pais> paises = ServicioPais.getInstancia().getListadoPais();
 %>
 <h1 class="page-header">Editar información de cuenta</h1>

	<form role="form">			

		<div class="form-group">
		    <label>Nombre:</label>
            <input type="text" name="nombre" id="nombre"  class="form-control input-lg" placeholder="Nombre" tabindex="1">
		</div>
	
		<div class="form-group">
		  <label>Apellido:</label>
			<input type="text" name="apellido" id="apellido"  class="form-control input-lg" placeholder="Apellido" tabindex="2">
		</div>

		<div class="form-group">
		    <label>Usuario:</label>
			<input type="text" name="usuario" id="usuario"  class="form-control input-lg" placeholder="Usuario" tabindex="3">
		</div>
		<div class="form-group">
		   <label>Telefono:</label>
			<input type="tel" name="telefono" id="telefono"  class="form-control input-lg" placeholder="Teléfono" tabindex="4">
		</div>
		
		<div class="form-group">
		    <label>Telefono:</label>
           <input type="text" name="calle" id="calle"  class="form-control input-lg" placeholder="Calle" tabindex="5">
	   </div>
	
		<div class="form-group">
		  <label>Apartamento:</label>
			<input type="text" name="apt" id="apt"  class="form-control input-lg" placeholder="Apartamento" tabindex="6">
	  </div>
	  <div class="form-group">
	 	<label>Ciudad:</label>
		<input type="text" name="ciudad" id="ciudad"  class="form-control input-lg" placeholder="Ciudad" tabindex="7">
	  </div>
	   <div class="form-group">
			  <label for="pais">País:</label>
			  <select class="form-control" id="pais" name="pais" tabindex="8">
			  <c:forEach items="<%=paises%>" var="pais">
                 <option value="${pais.getId()}">${pais.getDescripcion()}</option>        
               </c:forEach>
			  </select>
     </div>		
		
	<div class="row">
			<div class="col-xs-12 col-md-6"><input type="submit" value="Actualizar" class="btn btn-primary btn-block btn-lg" tabindex="12"></div>
			<div class="col-xs-12 col-md-6"><a href="<%=request.getContextPath()%>/app/index.jsp" class="btn btn-success btn-block btn-lg">Cancelar</a></div> 
	</div>
	</form>

<!--</div>-->
 <script src="js/signup.js"></script>
<jsp:include page="template/footer.jsp"/>