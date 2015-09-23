<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:public>
<jsp:attribute name="title">Portada</jsp:attribute>
 <jsp:body>
<!-- Jumbotron -->
<!-- Implementar templates carousel y jumbotron
 -->
 <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
     <div class="container">
    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="images/slides/slide1.png" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>PetCare</h1>
              <p>Las mejores atenciones para su mascota.</p>
              <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/signup.jsp" role="button">Registrarse Ahora</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="images/slides/slide2.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Personal Especializado</h1>
              <p>Conoce más sobre los servicios que ofrecemos y sobre cada uno de nuestro personal.</p>
              <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/about.jsp" role="button">Leer más</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="images/slides/slide3.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Su alegría, es nuestra mayor sastifación.</h1>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Anterior</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Siguiente</span>
      </a>
    </div><!-- /.carousel -->


  </div>
    </div>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Registrarse Hoy</h2>
          <p>Recibe las mejores atenciones en el cuidado de sus mascotas, personal especializado, buen servicios y excelentes precios </p>
          <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/signup.jsp" role="button">Registrarse</a></p>
        </div>
        <div class="col-md-4">
          <h2>Sobre Nosotros</h2>
          <p>Conoce más sobre los servicios que ofrecemos y sobre cada uno de nuestro personal. </p>
          <p><a class="btn btn-default btn-lg active" href="${pageContext.request.contextPath}/about.jsp" role="button">Leer más</a></p>
       </div>
        <div class="col-md-4">
          <h2>Contáctenos</h2>
          <p>Entre en contacto con nosotros. Escríbenos tus sugerencias o comentarios y en la mayor brevedad un representante se pondrá en contacto con usted</p>
          <p><a class="btn btn-default btn-lg active" href="${pageContext.request.contextPath}/contactos.jsp" role="button">Formulario de Contacto</a></p>
        </div>
      </div>

</jsp:body>
</t:public>