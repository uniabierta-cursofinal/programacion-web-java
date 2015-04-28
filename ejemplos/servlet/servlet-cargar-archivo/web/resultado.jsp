<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga de archivo</title>
    </head>
    <body>
        <h1>Resultado de carga</h1>
        <ul>
            <li>fileName:${fileName}</li>
            <li>contentType:${contentType}</li>
            <li>size:${size/1024.0} KB</li>
        </ul>
    </body>
</html>
