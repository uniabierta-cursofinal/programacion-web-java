<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar archivo</title>
    </head>
    <body>
        <h1>Cargar archivo</h1>
        <h2>Usando Servlet 3.0 (Java EE 7)</h2>
        <form method="POST" 
              action="${pageContext.servletContext.contextPath}/ServletSubirArchivo" 
              enctype="multipart/form-data">
            <label for="inputFile">Seleccione un archivo</label>
            <input type="file" name="inputFile"  id="inputFile" value="" />
            <button>Cargar</button>
        </form>
    </body>
</html>

