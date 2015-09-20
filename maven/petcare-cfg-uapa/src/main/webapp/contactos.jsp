<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"/> 
    <div class="container">
  
        <div>
            
            <h1>Formulario de Contacto</h1>
        </div>
    </div>
          
<div class="container">
<div class="row">
    
  <div class="col-md-12">
   
       <c:if test="${!empty mensajeOperacionExitoso}">
           <div class="alert alert-success"><strong><span class="glyphicon glyphicon-send">
               
                   </span>   <c:out value="${mensajeOperacionExitoso}"/></strong></div>	  
      </c:if>
        
       <c:if test="${!empty mensajeOperacionError}">
             <div class="alert alert-danger"><span class="glyphicon glyphicon-alert"></span>
                 <strong> <c:out value="${mensajeOperacionError}"/></strong></div>
       </c:if>        
       
  </div>
  <form role="form" action="${pageContext.request.contextPath}/ContactosController" method="post" >
    <div class="col-lg-6">
      <div class="well well-sm"><strong><i class="glyphicon glyphicon-ok form-control-feedback"></i> Required Field</strong></div>
      <div class="form-group">
        <label for="InputName">Nombre</label>
        <div class="input-group">
          <input type="text" class="form-control" name="inputNombre" id="InputName" placeholder="Escribir nombre " required>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputEmail">Email</label>
        <div class="input-group">
          <input type="email" class="form-control" id="InputEmail" name="inputEmail" placeholder="Correo Electrónico" required  >
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputMessage">Mensaje</label>
        <div class="input-group"
>
          <textarea name="inputMensaje" id="InputMessage" class="form-control" rows="5" required></textarea>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <div class="form-group">
        <label for="InputReal">Cuanto es 4+3? (Detector de Spam)</label>
        <div class="input-group">
          <input type="text" class="form-control" name="inputReal" id="InputReal" required>
          <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span></div>
      </div>
      <input type="submit" name="submit" id="submit" value="Enviar" class="btn btn-info pull-right">
    </div>
  </form>
  <hr class="featurette-divider hidden-lg">
  <div class="col-lg-5 col-md-push-1">
    <address>
    <h3>Ubicación</h3>
    <p class="lead"><a href="https://www.google.com/maps/@19.4398451,-70.6730233,12z" target="_blank">Santiago de los Caballeros<br>
Av. Hispanoamericana</a><br>
      Telefono: XXX-XXX-XXXX
    </address>
  </div>
</div>


  <jsp:include page="template/footer.jsp"/>