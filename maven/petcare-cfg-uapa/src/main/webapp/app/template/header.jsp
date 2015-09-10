<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Petcare</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<%=request.getContextPath()%>/js/ie-emulation-modes-warning.js"></script>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<%=request.getContextPath()%>/js/ie10-viewport-bug-workaround.js"></script>

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
          <a class="navbar-brand" href="<%=request.getContextPath()%>/app/index.jsp">PetCare</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/app/index.jsp"">Dashboard</a></li>
            <li><a href="<%=request.getContextPath()%>/app/cita/consultacitas.jsp">Cita</a></li>
            <li><a href="<%=request.getContextPath()%>/app/paciente/consultapacientes.jsp">Paciente</a></li>
            <li><a href="<%=request.getContextPath()%>/app/perfil.jsp">Mi Cuenta</a></li>
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
            <li><a href="<%=request.getContextPath()%>/app/admin/cita.jsp">Citas</a></li>
            <li><a href="<%=request.getContextPath()%>/app/admin/paciente.jsp">Pacientes</a></li>
            <li><a href="<%=request.getContextPath()%>/app/admin/pais.jsp">Paises</a></li>
            <li><a href="<%=request.getContextPath()%>/app/admin/cliente.jsp">Usuarios</a></li>
            <li><a href="<%=request.getContextPath()%>/app/admin/especie.jsp">Especies</a></li>
            <li><a href="<%=request.getContextPath()%>/app/admin/raza.jsp">Razas</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="<%=request.getContextPath()%>/app/admin/doctor.jsp">Doctores</a></li>            
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="<%=request.getContextPath()%>/app/perfil.jsp">Mi Cuenta</a></li>
            <li><a href="<%=request.getContextPath()%>/app/editarperfil.jsp">Editar Cuenta</a></li>
            <li><a href="<%=request.getContextPath()%>/app/cambiarcontrasena.jsp">Cambiar Contraseña</a></li>     
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Salir</a></li>                 
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        

