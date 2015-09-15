<%@tag description="Default Page template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="title" required="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">
	<title>Petcare | <c:out value="${!empty title ? title : ''}"/></title>    

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/js/ie10-viewport-bug-workaround.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/app/index.jsp">PetCare</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/app/index.jsp">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/CitaController?cmd=list">Cita</a></li>
            <li><a href="${pageContext.request.contextPath}/PacienteController?cmd=list">Paciente</a></li>
            <li><a href="${pageContext.request.contextPath}/ClienteController?cmd=show">Mi Cuenta</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Consultas</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=cita">Citas</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=paciente">Pacientes</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=pais">Paises</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=cliente">Clientes</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=especie">Especies</a></li>
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=raza">Razas</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${pageContext.request.contextPath}/AdminController?cmd=doctor">Doctores</a></li>            
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="${pageContext.request.contextPath}/ClienteController?cmd=show">Mi Cuenta</a></li>
            <li><a href="${pageContext.request.contextPath}/ClienteController?cmd=edit">Editar Cuenta</a></li>
            <li><a href="${pageContext.request.contextPath}/ClienteController?cmd=chpass">Cambiar Contraseña</a></li>     
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">Salir</a></li>                 
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         <h1 class="page-header"><c:out value="${!empty title ? title : ''}"/></h1>
         <jsp:doBody/>

        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/docs.min.js"></script>
  </body>
</html>